package com.bpjstk.JSReport.services.modules;

import com.bpjstk.JSReport.models.PostData;
import com.bpjstk.JSReport.models.PostDataBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
public class KNLSTPUService extends ModuleService {

    @Autowired
    public KNLSTPUService(DataService dataService) {
        super(dataService);
    }

    public byte[] getKNLSTPU022(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {

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

    public byte[] getKNLSTPU023(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {

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

    public PostData getKNLSTPU027(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {

        //get Data from Impala
        List<Map<String, Object>> data = dataService.getImpalaDataByQueryList(paramList, additionalData);

        //do something with data
        List<Map<String, Object>> groupedData = new ArrayList<>();
        Map<String, Map<String, Object>> groupMap = new HashMap<>();

        for (Map<String, Object> item : data) {
            String key = item.get("pembina") + "-" + item.get("nama_pembina");
            Map<String, Object> kantorGroup = groupMap.get(key);

            if (kantorGroup == null) {
                kantorGroup = new HashMap<>();
                kantorGroup.put("pembina", item.get("pembina"));
                kantorGroup.put("nama_pembina", item.get("nama_pembina"));
                kantorGroup.put("item", new ArrayList<Map<String, Object>>());
                groupMap.put(key, kantorGroup);
                groupedData.add(kantorGroup);
            }

            List<Map<String, Object>> items = (List<Map<String, Object>>) kantorGroup.get("item");
            Map<String, Object> newItem = new HashMap<>();
            newItem.put("npp", item.get("npp"));
            newItem.put("nama_perusahaan", item.get("nama_perusahaan"));
            newItem.put("tk_aktif", item.get("tk_aktif"));
            newItem.put("blth_rekon", item.get("blth_rekon"));
            newItem.put("skala_usaha", item.get("skala_usaha"));
            newItem.put("nama_ilo", item.get("nama_ilo"));

            items.add(newItem);
        }

        //post data to JSReport
        PostData postData = new PostData(
                additionalData.get("queryId"),
                additionalData.get("p_user"),
                additionalData.get("title"),
                additionalData.get("subtitle"),
                additionalData.get("blth"),
                additionalData.get("periode"),
                groupedData);
        return postData;

    }

    public byte[] getKNLSTPU028(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {

        //get Data from Impala
        List<Map<String, Object>> data = dataService.getImpalaDataByQueryList(paramList, additionalData);

        //do something with data
        List<Map<String, Object>> groupedData = new ArrayList<>();
        Map<String, Map<String, Object>> groupMap = new HashMap<>();

        for (Map<String, Object> item : data) {
            // Membentuk kunci berdasarkan pembina dan nama_pembina
            String key = item.get("pembina") + "-" + item.get("nama_pembina");
            Map<String, Object> kantorGroup = groupMap.get(key);

            if (kantorGroup == null) {
                // Jika grup belum ada, buat grup baru
                kantorGroup = new HashMap<>();
                kantorGroup.put("pembina", item.get("pembina"));
                kantorGroup.put("nama_pembina", item.get("nama_pembina"));
                kantorGroup.put("item", new ArrayList<Map<String, Object>>());
                groupMap.put(key, kantorGroup);
                groupedData.add(kantorGroup);
            }

            // Menambahkan item baru ke grup
            List<Map<String, Object>> items = (List<Map<String, Object>>) kantorGroup.get("item");
            Map<String, Object> newItem = new HashMap<>();
            newItem.put("nama_ilo", item.get("nama_ilo"));
            newItem.put("jml_prs_aktif", item.get("jml_prs_aktif"));
            newItem.put("tk_aktif_total", item.get("tk_aktif_total"));
            newItem.put("iuran", item.get("iuran"));

            items.add(newItem);
        }

        //post data to JSReport
        PostData postData = new PostData(
                additionalData.get("queryId"),
                additionalData.get("p_user"),
                additionalData.get("title"),
                additionalData.get("subtitle"),
                additionalData.get("blth"),
                additionalData.get("periode"),
                groupedData);
        return dataService.getFileFromJSReport(new PostDataBuilder(additionalData.get("shortId"), additionalData.get("recipe"), postData));

    }

    public byte[] getKNLSTPU029(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {

        //get Data from Impala
        List<Map<String, Object>> data = dataService.getImpalaDataByQueryList(paramList, additionalData);

        //do something with data
        List<Map<String, Object>> groupedData = new ArrayList<>();
        Map<String, Map<String, Object>> groupMap = new HashMap<>();

        for (Map<String, Object> item : data) {
            // Membentuk kunci berdasarkan pembina dan nama_pembina
            String key = item.get("pembina") + "-" + item.get("nama_pembina");
            Map<String, Object> kantorGroup = groupMap.get(key);

            if (kantorGroup == null) {
                // Jika grup belum ada, buat grup baru
                kantorGroup = new HashMap<>();
                kantorGroup.put("pembina", item.get("pembina"));
                kantorGroup.put("nama_pembina", item.get("nama_pembina"));
                kantorGroup.put("item", new ArrayList<Map<String, Object>>());
                groupMap.put(key, kantorGroup);
                groupedData.add(kantorGroup);
            }

            // Menambahkan item baru ke grup
            List<Map<String, Object>> items = (List<Map<String, Object>>) kantorGroup.get("item");
            Map<String, Object> newItem = new HashMap<>();
            newItem.put("nama_ilo", item.get("nama_ilo"));
            newItem.put("jml_prs_aktif", item.get("jml_prs_aktif"));
            newItem.put("tk_aktif_total", item.get("tk_aktif_total"));

            items.add(newItem);
        }

        //post data to JSReport
        PostData postData = new PostData(
                additionalData.get("queryId"),
                additionalData.get("p_user"),
                additionalData.get("title"),
                additionalData.get("subtitle"),
                additionalData.get("blth"),
                additionalData.get("periode"),
                groupedData);
        return dataService.getFileFromJSReport(new PostDataBuilder(additionalData.get("shortId"), additionalData.get("recipe"), postData));

    }

    public byte[] getKNLSTPU030(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {

        //get Data from Impala
        List<Map<String, Object>> data = dataService.getImpalaDataByQueryList(paramList, additionalData);

        //do something with data
        List<Map<String, Object>> groupedData = new ArrayList<>();
        Map<String, Map<String, Object>> groupMap = new HashMap<>();

        for (Map<String, Object> item : data) {
            // Membentuk kunci berdasarkan kode_kantor dan nama_kantor
            String key = item.get("kode_kantor") + "-" + item.get("nama_kantor");
            Map<String, Object> kantorGroup = groupMap.get(key);

            if (kantorGroup == null) {
                // Jika grup belum ada, buat grup baru
                kantorGroup = new HashMap<>();
                kantorGroup.put("kode_kantor", item.get("kode_kantor"));
                kantorGroup.put("nama_kantor", item.get("nama_kantor"));
                kantorGroup.put("item", new ArrayList<Map<String, Object>>());
                groupMap.put(key, kantorGroup);
                groupedData.add(kantorGroup);
            }

            // Menambahkan item baru ke grup
            List<Map<String, Object>> items = (List<Map<String, Object>>) kantorGroup.get("item");
            Map<String, Object> newItem = new HashMap<>();
            newItem.put("nama_ilo", item.get("nama_ilo"));
            newItem.put("jml_prs_aktif", item.get("jml_prs_aktif"));
            newItem.put("tk_aktif_total", item.get("tk_aktif_total"));

            items.add(newItem);
        }

        //post data to JSReport
        PostData postData = new PostData(
                additionalData.get("queryId"),
                additionalData.get("p_user"),
                additionalData.get("title"),
                additionalData.get("subtitle"),
                additionalData.get("blth"),
                additionalData.get("periode"),
                groupedData);
        return dataService.getFileFromJSReport(new PostDataBuilder(additionalData.get("shortId"), additionalData.get("recipe"), postData));

    }

    public byte[] getKNLSTPU031(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {

        //get Data from Impala
        List<Map<String, Object>> data = dataService.getImpalaDataByQueryList(paramList, additionalData);

        //do something with data
        List<Map<String, Object>> groupedData = new ArrayList<>();
        Map<String, Map<String, Object>> groupMap = new HashMap<>();

        for (Map<String, Object> item : data) {
            // Membentuk kunci berdasarkan kode_wilayah dan nama_wilayah
            String key = item.get("kode_wilayah") + "-" + item.get("nama_wilayah");
            Map<String, Object> wilayahGroup = groupMap.get(key);

            if (wilayahGroup == null) {
                // Jika grup belum ada, buat grup baru
                wilayahGroup = new HashMap<>();
                wilayahGroup.put("kode_wilayah", item.get("kode_wilayah"));
                wilayahGroup.put("nama_wilayah", item.get("nama_wilayah"));
                wilayahGroup.put("item", new ArrayList<Map<String, Object>>());
                groupMap.put(key, wilayahGroup);
                groupedData.add(wilayahGroup);
            }

            // Menambahkan item baru ke grup
            List<Map<String, Object>> items = (List<Map<String, Object>>) wilayahGroup.get("item");
            Map<String, Object> newItem = new HashMap<>();
            newItem.put("nama_ilo", item.get("nama_ilo"));
            newItem.put("jml_prs_aktif", item.get("jml_prs_aktif"));
            newItem.put("tk_aktif_total", item.get("tk_aktif_total"));

            items.add(newItem);
        }

        //post data to JSReport
        PostData postData = new PostData(
                additionalData.get("queryId"),
                additionalData.get("p_user"),
                additionalData.get("title"),
                additionalData.get("subtitle"),
                additionalData.get("blth"),
                additionalData.get("periode"),
                groupedData);
        return dataService.getFileFromJSReport(new PostDataBuilder(additionalData.get("shortId"), additionalData.get("recipe"), postData));

    }
}
