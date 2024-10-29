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
public class KNCLRService extends ModuleService {

    @Autowired
    public KNCLRService(DataService dataService) {
        super(dataService);
    }

    public byte[] getKNCLR00001(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {

        //get Data from Impala
        List<Map<String, Object>> data = dataService.getImpalaDataByQueryList(paramList, additionalData);

        //do something with data
        Map<String, Map<String, Object>> groupedDataMap = new HashMap<>();

        for (Map<String, Object> item : data) {
            String officeKey = (String) item.get("nama_kantor");

            Map<String, Object> kantorGroup = groupedDataMap.get(officeKey);
            if (kantorGroup == null) {
                kantorGroup = new HashMap<>();
                kantorGroup.put("nama_kantor", item.get("nama_kantor"));
                kantorGroup.put("item", new ArrayList<Map<String, Object>>());

                groupedDataMap.put(officeKey, kantorGroup);
            }

            // Tambahkan item ke grup yang sesuai
            List<Map<String, Object>> items = (List<Map<String, Object>>) kantorGroup.get("item");
            Map<String, Object> newItem = new HashMap<>();
            newItem.put("kd_kw", item.get("kd_kw"));
            newItem.put("kd_kc", item.get("kd_kc"));
            newItem.put("status", item.get("status"));
            newItem.put("prs_jml", item.get("prs_jml"));
            newItem.put("prs_persen", item.get("prs_persen"));
            newItem.put("tk_aktif", item.get("tk_aktif"));
            newItem.put("tk_non_aktif", item.get("tk_non_aktif"));
            newItem.put("tk_jml", item.get("tk_jml"));
            newItem.put("pds_tk_jml_sebenarnya", item.get("pds_tk_jml_sebenarnya"));
            newItem.put("pds_tk_jml", item.get("pds_tk_jml"));
            newItem.put("pds_tk_persen", item.get("pds_tk_persen"));
            newItem.put("pds_tk_iuran", item.get("pds_tk_iuran"));
            newItem.put("pds_upah_ump", item.get("pds_upah_ump"));
            newItem.put("pds_upah_tk", item.get("pds_upah_tk"));
            newItem.put("pds_upah_iuran", item.get("pds_upah_iuran"));
            newItem.put("pds_program_tdk_wajib_jp", item.get("pds_program_tdk_wajib_jp"));
            newItem.put("pds_program_tk_jht", item.get("pds_program_tk_jht"));
            newItem.put("pds_program_tk_jp", item.get("pds_program_tk_jp"));
            newItem.put("pds_program_iuran", item.get("pds_program_iuran"));

            items.add(newItem);
        }

        // Ubah Map menjadi List yang berisi data grouping
        List<Map<String, Object>> groupedData = new ArrayList<>(groupedDataMap.values());

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

    public byte[] getKNCLR00003(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {

        //get Data from Impala
        List<Map<String, Object>> data = dataService.getImpalaDataByQueryList(paramList, additionalData);

        //do something with data
        Map<String, Map<String, Object>> groupedDataMap = new HashMap<>();

        for (Map<String, Object> item : data) {
            String wilayahKey = item.get("kode_wilayah") + "_" + item.get("nama_wilayah");

            Map<String, Object> wilayahGroup = groupedDataMap.get(wilayahKey);
            if (wilayahGroup == null) {
                wilayahGroup = new HashMap<>();
                wilayahGroup.put("kode_wilayah", item.get("kode_wilayah"));
                wilayahGroup.put("nama_wilayah", item.get("nama_wilayah"));
                wilayahGroup.put("item", new ArrayList<Map<String, Object>>());

                groupedDataMap.put(wilayahKey, wilayahGroup);
            }

            // Tambahkan item ke grup yang sesuai
            List<Map<String, Object>> items = (List<Map<String, Object>>) wilayahGroup.get("item");
            Map<String, Object> newItem = new HashMap<>();
            newItem.put("kode_kantor", item.get("kode_kantor"));
            newItem.put("status", item.get("status"));
            newItem.put("nama_kantor", item.get("nama_kantor"));
            newItem.put("prs_jml", item.get("prs_jml"));
            newItem.put("prs_persen", item.get("prs_persen"));
            newItem.put("pkbu_aktif", item.get("pkbu_aktif"));
            newItem.put("pkbu_persen", item.get("pkbu_persen"));
            newItem.put("tk_aktif", item.get("tk_aktif"));
            newItem.put("tk_non_aktif", item.get("tk_non_aktif"));
            newItem.put("tk_jml", item.get("tk_jml"));
            newItem.put("pds_tk_jml_sebenarnya", item.get("pds_tk_jml_sebenarnya"));
            newItem.put("pds_tk_jml", item.get("pds_tk_jml"));
            newItem.put("pds_tk_persen", item.get("pds_tk_persen"));
            newItem.put("pds_tk_iuran", item.get("pds_tk_iuran"));
            newItem.put("pds_upah_ump", item.get("pds_upah_ump"));
            newItem.put("pds_upah_tk", item.get("pds_upah_tk"));
            newItem.put("pds_upah_persen", item.get("pds_upah_persen"));
            newItem.put("pds_upah_iuran", item.get("pds_upah_iuran"));
            newItem.put("pds_program_tdk_wajib_jp", item.get("pds_program_tdk_wajib_jp"));
            newItem.put("pds_program_tk_jht", item.get("pds_program_tk_jht"));
            newItem.put("pds_program_tk_jp", item.get("pds_program_tk_jp"));
            newItem.put("pds_program_iuran", item.get("pds_program_iuran"));

            items.add(newItem);
        }

        // Ubah Map menjadi List yang berisi data grouping
        List<Map<String, Object>> groupedData = new ArrayList<>(groupedDataMap.values());

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

    public byte[] getKNCLR00005(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {

        //get Data from Impala
        List<Map<String, Object>> data = dataService.getImpalaDataByQueryList(paramList, additionalData);

        //do something with data
        Map<String, Map<String, Object>> groupedDataMap = new HashMap<>();

        for (Map<String, Object> item : data) {
            String officeKey = item.get("kode_kantor") + "_" + item.get("nama_kantor");

            Map<String, Object> officeGroup = groupedDataMap.get(officeKey);
            if (officeGroup == null) {
                officeGroup = new HashMap<>();
                officeGroup.put("kode_kantor", item.get("kode_kantor"));
                officeGroup.put("nama_kantor", item.get("nama_kantor"));
                officeGroup.put("data", new ArrayList<Map<String, Object>>());

                groupedDataMap.put(officeKey, officeGroup);
            }

            // Tambahkan item ke grup yang sesuai
            List<Map<String, Object>> items = (List<Map<String, Object>>) officeGroup.get("data");
            Map<String, Object> newItem = new HashMap<>();
            newItem.put("kode_pembina", item.get("kode_pembina"));
            newItem.put("nama_pembina", item.get("nama_pembina"));
            newItem.put("status", item.get("status"));
            newItem.put("prs_jml", item.get("prs_jml"));
            newItem.put("prs_persen", item.get("prs_persen"));
            newItem.put("tk_aktif", item.get("tk_aktif"));
            newItem.put("tk_non_aktif", item.get("tk_non_aktif"));
            newItem.put("tk_jml", item.get("tk_jml"));
            newItem.put("pds_tk_jml_sebenarnya", item.get("pds_tk_jml_sebenarnya"));
            newItem.put("pds_tk_jml", item.get("pds_tk_jml"));
            newItem.put("pds_tk_persen", item.get("pds_tk_persen"));
            newItem.put("pds_tk_iuran", item.get("pds_tk_iuran"));
            newItem.put("pds_upah_ump", item.get("pds_upah_ump"));
            newItem.put("pds_upah_tk", item.get("pds_upah_tk"));
            newItem.put("pds_upah_iuran", item.get("pds_upah_iuran"));
            newItem.put("pds_program_tdk_wajib_jp", item.get("pds_program_tdk_wajib_jp"));
            newItem.put("pds_program_tk_jht", item.get("pds_program_tk_jht"));
            newItem.put("pds_program_tk_jp", item.get("pds_program_tk_jp"));
            newItem.put("pds_program_iuran", item.get("pds_program_iuran"));

            items.add(newItem);
        }

        // Ubah Map menjadi List yang berisi data grouping
        List<Map<String, Object>> groupedData = new ArrayList<>(groupedDataMap.values());

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

    public byte[] getKNCLR00008(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {

        //get Data from Impala
        List<Map<String, Object>> data = dataService.getImpalaDataByQueryList(paramList, additionalData);

        //do something with data
        Map<String, Map<String, Object>> groupedDataMap = new HashMap<>();

        for (Map<String, Object> item : data) {
            String officeKey = (String) item.get("nama_pembina");

            Map<String, Object> pembinaGroup = groupedDataMap.get(officeKey);
            if (pembinaGroup == null) {
                pembinaGroup = new HashMap<>();
                pembinaGroup.put("nama_pembina", item.get("nama_pembina"));
                pembinaGroup.put("dataItems", new ArrayList<Map<String, Object>>());

                groupedDataMap.put(officeKey, pembinaGroup);
            }

            // Tambahkan item ke grup yang sesuai
            List<Map<String, Object>> items = (List<Map<String, Object>>) pembinaGroup.get("dataItems");
            Map<String, Object> newItem = new HashMap<>();
            newItem.put("npp", item.get("npp"));
            newItem.put("divisi", item.get("divisi"));
            newItem.put("nama_bu", item.get("nama_bu"));
            newItem.put("kode_keps", item.get("kode_keps"));
            newItem.put("keps_awal", item.get("keps_awal"));
            newItem.put("keps_jp", item.get("keps_jp"));
            newItem.put("blth", item.get("blth"));
            newItem.put("nilai", item.get("nilai"));
            newItem.put("aset_omset", item.get("aset_omset"));
            newItem.put("skala_iuran", item.get("skala_iuran"));
            newItem.put("tk_aktif", item.get("tk_aktif"));
            newItem.put("tk_non_aktif", item.get("tk_non_aktif"));
            newItem.put("tk_jumlah", item.get("tk_jumlah"));
            newItem.put("tk_sebenarnya", item.get("tk_sebenarnya"));
            newItem.put("jumlah_pds_tk", item.get("jumlah_pds_tk"));
            newItem.put("iuran_pds_tk", item.get("iuran_pds_tk"));
            newItem.put("sumber", item.get("sumber"));
            newItem.put("bpjstk_clearance", item.get("bpjstk_clearance"));

            items.add(newItem);
        }

        // Ubah Map menjadi List yang berisi data grouping
        List<Map<String, Object>> groupedData = new ArrayList<>(groupedDataMap.values());

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

    public byte[] getKNCLR00009(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {

        //get Data from Impala
        List<Map<String, Object>> data = dataService.getImpalaDataByQueryList(paramList, additionalData);

        //do something with data
        Map<String, Map<String, Object>> groupedDataMap = new HashMap<>();

        for (Map<String, Object> item : data) {
            String officeKey = (String) item.get("nama_pembina");

            Map<String, Object> pembinaGroup = groupedDataMap.get(officeKey);
            if (pembinaGroup == null) {
                pembinaGroup = new HashMap<>();
                pembinaGroup.put("nama_pembina", item.get("nama_pembina"));
                pembinaGroup.put("dataItems", new ArrayList<Map<String, Object>>());

                groupedDataMap.put(officeKey, pembinaGroup);
            }

            // Tambahkan item ke grup yang sesuai
            List<Map<String, Object>> items = (List<Map<String, Object>>) pembinaGroup.get("dataItems");
            Map<String, Object> newItem = new HashMap<>();
            newItem.put("npp", item.get("npp"));
            newItem.put("divisi", item.get("divisi"));
            newItem.put("nama_bu", item.get("nama_bu"));
            newItem.put("kode_keps", item.get("kode_keps"));
            newItem.put("keps_awal", item.get("keps_awal"));
            newItem.put("keps_jp", item.get("keps_jp"));
            newItem.put("blth", item.get("blth"));
            newItem.put("nilai", item.get("nilai"));
            newItem.put("aset_omset", item.get("aset_omset"));
            newItem.put("skala_iuran", item.get("skala_iuran"));
            newItem.put("tk_aktif", item.get("tk_aktif"));
            newItem.put("tk_non_aktif", item.get("tk_non_aktif"));
            newItem.put("tk_jumlah", item.get("tk_jumlah"));
            newItem.put("tk_kecil_ump", item.get("tk_kecil_ump"));
            newItem.put("pds_upah", item.get("pds_upah"));
            newItem.put("potensi_iuran", item.get("potensi_iuran"));
            newItem.put("sumber", item.get("sumber"));
            newItem.put("bpjstk_clearance", item.get("bpjstk_clearance"));

            items.add(newItem);
        }

        // Ubah Map menjadi List yang berisi data grouping
        List<Map<String, Object>> groupedData = new ArrayList<>(groupedDataMap.values());

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

    public byte[] getKNCLR00011(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {

        //get Data from Impala
        List<Map<String, Object>> data = dataService.getImpalaDataByQueryList(paramList, additionalData);

        //do something with data
        Map<String, Map<String, Object>> groupedDataMap = new HashMap<>();

        for (Map<String, Object> item : data) {
            String officeKey = (String) item.get("nama_pembina");

            Map<String, Object> pembinaGroup = groupedDataMap.get(officeKey);
            if (pembinaGroup == null) {
                pembinaGroup = new HashMap<>();
                pembinaGroup.put("nama_pembina", item.get("nama_pembina"));
                pembinaGroup.put("dataItems", new ArrayList<Map<String, Object>>());

                groupedDataMap.put(officeKey, pembinaGroup);
            }

            // Tambahkan item ke grup yang sesuai
            List<Map<String, Object>> items = (List<Map<String, Object>>) pembinaGroup.get("dataItems");
            Map<String, Object> newItem = new HashMap<>();
            newItem.put("npp", item.get("npp"));
            newItem.put("divisi", item.get("divisi"));
            newItem.put("nama_bu", item.get("nama_bu"));
            newItem.put("kode_keps", item.get("kode_keps"));
            newItem.put("keps_awal", item.get("keps_awal"));
            newItem.put("keps_jp", item.get("keps_jp"));
            newItem.put("blth", item.get("blth"));
            newItem.put("nilai", item.get("nilai"));
            newItem.put("aset_omset", item.get("aset_omset"));
            newItem.put("skala_iuran", item.get("skala_iuran"));
            newItem.put("tk_aktif", item.get("tk_aktif"));
            newItem.put("tk_non_aktif", item.get("tk_non_aktif"));
            newItem.put("tk_jumlah", item.get("tk_jumlah"));
            newItem.put("tk_usia_56_asing", item.get("tk_usia_56_asing"));
            newItem.put("tk_pds_jht", item.get("tk_pds_jht"));
            newItem.put("tk_pds_jp", item.get("tk_pds_jp"));
            newItem.put("potensi_iuran", item.get("potensi_iuran"));
            newItem.put("bpjstk_clearance", item.get("bpjstk_clearance"));

            items.add(newItem);
        }

        // Ubah Map menjadi List yang berisi data grouping
        List<Map<String, Object>> groupedData = new ArrayList<>(groupedDataMap.values());

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
