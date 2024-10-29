package com.bpjstk.JSReport.services.modules;


import com.bpjstk.JSReport.models.PostData;
import com.bpjstk.JSReport.models.PostDataBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
public class PNRService extends ModuleService {

    @Autowired
    public PNRService(DataService dataService) {
        super(dataService);
    }

    public byte[] getPNR8601(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {
        //get Data from Impala
        List<Map<String, Object>> data = dataService.getImpalaDataByQueryList(paramList, additionalData);

        //do something with data

        //post data to JSReport
        PostData postData = new PostData(
                additionalData.get("queryId"),
                additionalData.get("p_user"),
                additionalData.get("title"),
                additionalData.get("subtitle"),
                additionalData.get("blth"),
                additionalData.get("periode"),
                data);
        return dataService.getFileFromJSReport(new PostDataBuilder(additionalData.get("shortId"), additionalData.get("recipe"), postData));

    }

    public byte[] getPNR8604(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {
        //get Data from Impala
        List<Map<String, Object>> data = dataService.getImpalaDataByQueryList(paramList, additionalData);

        //do something with data

        //post data to JSReport
        PostData postData = new PostData(
                additionalData.get("queryId"),
                additionalData.get("p_user"),
                additionalData.get("title"),
                additionalData.get("subtitle"),
                additionalData.get("blth"),
                additionalData.get("periode"),
                data);
        return dataService.getFileFromJSReport(new PostDataBuilder(additionalData.get("shortId"), additionalData.get("recipe"), postData));

    }

    public byte[] getPNR8607(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {
        //get Data from Impala
        List<Map<String, Object>> data = dataService.getImpalaDataByQueryList(paramList, additionalData);

        //do something with data

        //post data to JSReport
        PostData postData = new PostData(
                additionalData.get("queryId"),
                additionalData.get("p_user"),
                additionalData.get("title"),
                additionalData.get("subtitle"),
                additionalData.get("blth"),
                additionalData.get("periode"),
                data);
        return dataService.getFileFromJSReport(new PostDataBuilder(additionalData.get("shortId"), additionalData.get("recipe"), postData));

    }

    public byte[] getPNR8611(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {
        //get Data from Impala
        List<Map<String, Object>> data = dataService.getImpalaDataByQueryList(paramList, additionalData);

        //do something with data

        //post data to JSReport
        PostData postData = new PostData(
                additionalData.get("queryId"),
                additionalData.get("p_user"),
                additionalData.get("title"),
                additionalData.get("subtitle"),
                additionalData.get("blth"),
                additionalData.get("periode"),
                data);
        return dataService.getFileFromJSReport(new PostDataBuilder(additionalData.get("shortId"), additionalData.get("recipe"), postData));

    }

    public byte[] getPNR8621(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {
        //get Data from Impala
        List<Map<String, Object>> data = dataService.getImpalaDataByQueryList(paramList, additionalData);

        //do something with data

        //post data to JSReport
        PostData postData = new PostData(
                additionalData.get("queryId"),
                additionalData.get("p_user"),
                additionalData.get("title"),
                additionalData.get("subtitle"),
                additionalData.get("blth"),
                additionalData.get("periode"),
                data);
        return dataService.getFileFromJSReport(new PostDataBuilder(additionalData.get("shortId"), additionalData.get("recipe"), postData));

    }

    public byte[] getPNR8624(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {
        //get Data from Impala
        List<Map<String, Object>> data = dataService.getImpalaDataByQueryList(paramList, additionalData);

        //do something with data

        //post data to JSReport
        PostData postData = new PostData(
                additionalData.get("queryId"),
                additionalData.get("p_user"),
                additionalData.get("title"),
                additionalData.get("subtitle"),
                additionalData.get("blth"),
                additionalData.get("periode"),
                data);
        return dataService.getFileFromJSReport(new PostDataBuilder(additionalData.get("shortId"), additionalData.get("recipe"), postData));

    }

    public byte[] getPNR8627(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {
        //get Data from Impala
        List<Map<String, Object>> data = dataService.getImpalaDataByQueryList(paramList, additionalData);

        //do something with data

        //post data to JSReport
        PostData postData = new PostData(
                additionalData.get("queryId"),
                additionalData.get("p_user"),
                additionalData.get("title"),
                additionalData.get("subtitle"),
                additionalData.get("blth"),
                additionalData.get("periode"),
                data);
        return dataService.getFileFromJSReport(new PostDataBuilder(additionalData.get("shortId"), additionalData.get("recipe"), postData));

    }

    public byte[] getPNR8631(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {
        //get Data from Impala
        List<Map<String, Object>> data = dataService.getImpalaDataByQueryList(paramList, additionalData);

        //do something with data

        //post data to JSReport
        PostData postData = new PostData(
                additionalData.get("queryId"),
                additionalData.get("p_user"),
                additionalData.get("title"),
                additionalData.get("subtitle"),
                additionalData.get("blth"),
                additionalData.get("periode"),
                data);
        return dataService.getFileFromJSReport(new PostDataBuilder(additionalData.get("shortId"), additionalData.get("recipe"), postData));

    }


}



