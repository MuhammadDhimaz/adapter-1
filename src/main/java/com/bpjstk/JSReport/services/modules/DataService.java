package com.bpjstk.JSReport.services.modules;

import com.bpjstk.JSReport.models.PostDataBuilder;
import com.bpjstk.JSReport.models.Query;
import com.bpjstk.JSReport.services.networks.ImpalaService;
import com.bpjstk.JSReport.services.networks.NetworkService;
import com.bpjstk.JSReport.services.networks.QueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;


@Service
public class DataService {
    protected static final Logger log = LoggerFactory.getLogger(DataService.class);
    protected final ImpalaService impalaService;
    protected final QueryService queryService;
    protected final NetworkService networkService;


    @Autowired
    public DataService(ImpalaService impalaService, QueryService queryService, NetworkService networkService) {
        this.impalaService = impalaService;
        this.queryService = queryService;
        this.networkService = networkService;
    }

    public List<Map<String, Object>> getImpalaDataByQueryList(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {
        Query query = getQueryInstanceById(additionalData.get("queryId")).get();
        additionalData.put("shortId", query.getShortId());
        List<String> queryList = getQueryList(query);
        return getListDataFromImpala(queryList, paramList, additionalData);
    }

    public List<Map<String, Object>> getListDataFromImpala(List<String> queryList, List<Map<String, String>> paramList, Map<String, String> additionalData) {
        long startTime = System.nanoTime();
        try {
            List<Map<String, Object>> data = getAllDataFromImpala(paramList, queryList).get();
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000;
            log.info("Get data from database took {} ms, with data size {}", duration, data.size());
            return data;
        } catch (InterruptedException | ExecutionException e) {
            log.error("Error fetching data from Impala", e);
            Thread.currentThread().interrupt();
            return Collections.emptyList();
        }
    }

    protected CompletableFuture<List<Map<String, Object>>> getAllDataFromImpala(List<Map<String, String>> paramList, List<String> queryList) {
        List<CompletableFuture<List<Map<String, Object>>>> futures = queryList.stream()
                .map(query -> impalaService.getListData(query, paramList))
                .toList();
        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(v -> futures.stream()
                        .map(CompletableFuture::join)
                        .flatMap(List::stream)
                        .collect(Collectors.toList())
                );
    }


    public CompletableFuture<Query> getQueryInstanceById(String queryId) {
        return queryService.getQueryById(queryId);
    }

    protected List<String> getQueryList(Query query) throws DataAccessException {
        return query.getQueryList();
    }

    protected byte[] getFileFromJSReport(PostDataBuilder data) throws DataAccessException, InterruptedException, ExecutionException {
        CompletableFuture<byte[]> getFile = networkService.post(data);
        return getFile.get();
    }


}

