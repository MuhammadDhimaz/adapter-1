package com.bpjstk.JSReport.services.networks;

import com.bpjstk.JSReport.models.Query;
import com.bpjstk.JSReport.repositories.QueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;

@Service
public class QueryService {
    @Autowired
    private QueryRepository queryRepository;

    @Async
    public CompletableFuture<Query> getQueryById(String id) {
        return CompletableFuture.completedFuture(queryRepository.findById(id).orElse(null));
    }

    public Query updateQueryById(String id) throws DataAccessException, IOException {
        byte[] fileBytes = Files.readAllBytes(Paths.get("src/main/resources/databases/update.txt"));
        String newSql = new String(fileBytes);
        queryRepository.updateQueryById(id, newSql);
        return queryRepository.findById(id).orElse(null);
    }
}

