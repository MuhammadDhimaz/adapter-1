package com.bpjstk.JSReport.services.networks;


import com.bpjstk.JSReport.repositories.ImpalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class ImpalaService {
    @Autowired
    private ImpalaRepository impalaRepository;

    @Async
    public CompletableFuture<List<Map<String, Object>>> getListData(String sql, List<Map<String, String>> paramList) {
        return impalaRepository.executeQueryForList(sql, paramList);
    }
}
