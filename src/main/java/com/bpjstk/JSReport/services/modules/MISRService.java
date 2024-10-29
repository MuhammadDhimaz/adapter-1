package com.bpjstk.JSReport.services.modules;

import com.bpjstk.JSReport.models.PostData;
import com.bpjstk.JSReport.models.PostDataBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
public class MISRService extends ModuleService {

    @Autowired
    public MISRService(DataService dataService) {
        super(dataService);
    }


    public byte[] getMISR1001(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {
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

    public byte[] getMISR1002(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {
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

    public byte[] getMISR1003(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {
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

    public byte[] getMISR1004(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {
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

    public byte[] getMISR1005(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {
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

    public byte[] getMISR1006(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {
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

    public byte[] getMISR1007(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {
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

    public byte[] getMISR1008(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {
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

    public byte[] getMISR1010(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {
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

    public byte[] getMISR1011(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {
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

    public byte[] getMISR1012(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {
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
