package com.bpjstk.JSReport.services.modules;

import com.bpjstk.JSReport.models.Query;
import com.bpjstk.JSReport.services.networks.ImpalaService;
import com.bpjstk.JSReport.services.networks.NetworkService;
import com.bpjstk.JSReport.services.networks.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Service
public class CommonService extends DataService {

    @Autowired
    public CommonService(ImpalaService impalaService, QueryService queryService, NetworkService networkService) {
        super(impalaService, queryService, networkService);
    }

    public String updateData(String id) throws DataAccessException, IOException, ExecutionException, InterruptedException {
        Query result = queryService.updateQueryById(id);
        return result.getQuery1();
    }


}
