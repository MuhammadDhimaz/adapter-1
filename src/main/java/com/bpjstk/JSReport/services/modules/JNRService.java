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
public class JNRService extends ModuleService {

    @Autowired
    public JNRService(DataService dataService) {
        super(dataService);
    }

    public byte[] getJNR3001(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {

        //get Data from Impala
        List<Map<String, Object>> data = dataService.getImpalaDataByQueryList(paramList, additionalData);

        //do something with data
        List<Map<String, Object>> groupedData = new ArrayList<>();
        Map<String, Map<String, Object>> groupedDataMap = new HashMap<>();

        for (Map<String, Object> item : data) {
            String key = item.get("kode_kantor") + "|" + item.get("nama_kantor") + "|" +
                    item.get("kode_pembina") + "|" + item.get("nama_pembina");

            Map<String, Object> kantorGroup = groupedDataMap.get(key);

            if (kantorGroup == null) {
                kantorGroup = new HashMap<>();
                kantorGroup.put("kode_kantor", item.get("kode_kantor"));
                kantorGroup.put("nama_kantor", item.get("nama_kantor"));
                kantorGroup.put("kode_pembina", item.get("kode_pembina"));
                kantorGroup.put("nama_pembina", item.get("nama_pembina"));
                kantorGroup.put("item", new ArrayList<Map<String, Object>>());
                groupedDataMap.put(key, kantorGroup);
                groupedData.add(kantorGroup);
            }

            List<Map<String, Object>> items = (List<Map<String, Object>>) kantorGroup.get("item");
            Map<String, Object> newItem = new HashMap<>();
            newItem.put("no_proyek", item.get("no_proyek"));
            newItem.put("nama_proyek", item.get("nama_proyek"));
            newItem.put("npp", item.get("npp"));
            newItem.put("nama_perusahaan", item.get("nama_perusahaan"));
            newItem.put("tgl_awal_proyek", item.get("tgl_awal_proyek"));
            newItem.put("tgl_akhir_proyek", item.get("tgl_akhir_proyek"));
            newItem.put("tgl_akhir_pemeliharaan", item.get("tgl_akhir_pemeliharaan"));
            newItem.put("nilai_proyek", item.get("nilai_proyek"));
            newItem.put("nilai_iuran", item.get("nilai_iuran"));
            newItem.put("jml_entry", item.get("jml_entry"));
            newItem.put("jml_bnba", item.get("jml_bnba"));

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

    public byte[] getJNR3002(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {

        //get Data from Impala
        List<Map<String, Object>> data = dataService.getImpalaDataByQueryList(paramList, additionalData);

        //do something with data
        Map<String, Map<String, Object>> groupedDataMap = new HashMap<>();

        for (Map<String, Object> item : data) {
            String regionKey = item.get("kode_wilayah") + "_" + item.get("nama_wilayah");
            String officeKey = item.get("kode_kantor") + "_" + item.get("nama_kantor");

            groupedDataMap.computeIfAbsent(regionKey, k -> {
                Map<String, Object> regionGroup = new HashMap<>();
                regionGroup.put("kode_wilayah", item.get("kode_wilayah"));
                regionGroup.put("nama_wilayah", item.get("nama_wilayah"));
                regionGroup.put("data", new HashMap<String, Map<String, Object>>());
                return regionGroup;
            });

            Map<String, Map<String, Object>> officeDataMap = (Map<String, Map<String, Object>>) groupedDataMap.get(regionKey).get("data");

            officeDataMap.computeIfAbsent(officeKey, k -> {
                Map<String, Object> officeGroup = new HashMap<>();
                officeGroup.put("kode_kantor", item.get("kode_kantor"));
                officeGroup.put("nama_kantor", item.get("nama_kantor"));
                officeGroup.put("item", new ArrayList<Map<String, Object>>());
                return officeGroup;
            });

            List<Map<String, Object>> items = (List<Map<String, Object>>) officeDataMap.get(officeKey).get("item");

            Map<String, Object> newItem = new HashMap<>();
            newItem.put("kode_pembina", item.get("kode_pembina"));
            newItem.put("nama_pembina", item.get("nama_pembina"));
            newItem.put("nilai_proyek", item.get("nilai_proyek"));
            newItem.put("nilai_iuran", item.get("nilai_iuran"));
            newItem.put("jml_tk", item.get("jml_tk"));
            newItem.put("jml_tk_bnba", item.get("jml_tk_bnba"));
            newItem.put("jml_proyek", item.get("jml_proyek"));
            newItem.put("jml_proyek_bnba", item.get("jml_proyek_bnba"));
            newItem.put("periodex", item.get("periodex"));
            newItem.put("persen_proyek", item.get("persen_proyek"));
            newItem.put("persen_tk", item.get("persen_tk"));

            items.add(newItem);
        }

        // Konversi hasil ke dalam bentuk List<Map<String, Object>>
        List<Map<String, Object>> groupedData = new ArrayList<>();
        for (Map<String, Object> region : groupedDataMap.values()) {
            Map<String, Map<String, Object>> officeData = (Map<String, Map<String, Object>>) region.get("data");
            region.put("data", new ArrayList<>(officeData.values()));
            groupedData.add(region);
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

    public byte[] getJNR3003(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {

        //get Data from Impala
        List<Map<String, Object>> data = dataService.getImpalaDataByQueryList(paramList, additionalData);

        //do something with data
        List<Map<String, Object>> groupedData = new ArrayList<>();
        Map<String, Map<String, Object>> kantorMap = new HashMap<>();

        for (Map<String, Object> item : data) {
            String key = item.get("kode_proyek") + "-" + item.get("no_proyek") + "-" + item.get("nama_proyek") + "-"
                    + item.get("kode_kantor") + "-" + item.get("nama_kantor") + "-" + item.get("kode_pembina") + "-"
                    + item.get("nama_pembina");

            Map<String, Object> kantorGroup = kantorMap.get(key);
            if (kantorGroup == null) {
                kantorGroup = new HashMap<>();
                kantorGroup.put("kode_proyek", item.get("kode_proyek"));
                kantorGroup.put("no_proyek", item.get("no_proyek"));
                kantorGroup.put("nama_proyek", item.get("nama_proyek"));
                kantorGroup.put("kode_kantor", item.get("kode_kantor"));
                kantorGroup.put("nama_kantor", item.get("nama_kantor"));
                kantorGroup.put("kode_pembina", item.get("kode_pembina"));
                kantorGroup.put("nama_pembina", item.get("nama_pembina"));
                kantorGroup.put("item", new ArrayList<Map<String, Object>>());

                kantorMap.put(key, kantorGroup);
                groupedData.add(kantorGroup);
            }

            List<Map<String, Object>> items = (List<Map<String, Object>>) kantorGroup.get("item");
            Map<String, Object> newItem = new HashMap<>();
            newItem.put("kode_tk", item.get("kode_tk"));
            newItem.put("nomor_identitas", item.get("nomor_identitas"));
            newItem.put("nama", item.get("nama"));
            newItem.put("tgl_lahir", item.get("tgl_lahir"));
            newItem.put("alamat", item.get("alamat"));
            newItem.put("tgl_rekam", item.get("tgl_rekam"));
            newItem.put("tgl_mulai_bekerja", item.get("tgl_mulai_bekerja"));
            newItem.put("nama_pekerjaan", item.get("nama_pekerjaan"));
            newItem.put("periodex", item.get("periodex"));
            newItem.put("harga_satuan_upah", item.get("harga_satuan_upah"));

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

    public byte[] getJNR3004(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {

        //get Data from Impala
        List<Map<String, Object>> data = dataService.getImpalaDataByQueryList(paramList, additionalData);

        //do something with data
        Map<String, Map<String, Object>> groupedDataMap = new HashMap<>();

        for (Map<String, Object> item : data) {
            // Buat kunci unik berdasarkan kode_wilayah dan nama_wilayah
            String key = item.get("kode_wilayah") + "_" + item.get("nama_wilayah");

            // Jika belum ada grup untuk kunci ini, buat grup baru
            Map<String, Object> wilayahGroup = groupedDataMap.get(key);
            if (wilayahGroup == null) {
                wilayahGroup = new HashMap<>();
                wilayahGroup.put("kode_wilayah", item.get("kode_wilayah"));
                wilayahGroup.put("nama_wilayah", item.get("nama_wilayah"));
                wilayahGroup.put("item", new ArrayList<Map<String, Object>>());

                groupedDataMap.put(key, wilayahGroup);
            }

            // Tambahkan item ke dalam sub-grup item dari wilayahGroup
            List<Map<String, Object>> items = (List<Map<String, Object>>) wilayahGroup.get("item");
            Map<String, Object> newItem = new HashMap<>();
            newItem.put("kode_kantor", item.get("kode_kantor"));
            newItem.put("nama_kantor", item.get("nama_kantor"));
            newItem.put("kode_pembina", item.get("kode_pembina"));
            newItem.put("nama_pembina", item.get("nama_pembina"));
            newItem.put("nilai_proyek", item.get("nilai_proyek"));
            newItem.put("nilai_iuran", item.get("nilai_iuran"));
            newItem.put("jml_proyek", item.get("jml_proyek"));
            newItem.put("jml_tk", item.get("jml_tk"));
            newItem.put("jml_tk_bnba", item.get("jml_tk_bnba"));
            newItem.put("jml_proyek_bnba", item.get("jml_proyek_bnba"));
            newItem.put("periodex", item.get("periodex"));
            newItem.put("persen_proyek", item.get("persen_proyek"));
            newItem.put("persen_tk", item.get("persen_tk"));

            items.add(newItem);
        }

        // Konversi groupedDataMap menjadi List
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

    public byte[] getJNR3005(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {

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

    public byte[] getJNR3006(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {

        //get Data from Impala
        List<Map<String, Object>> data = dataService.getImpalaDataByQueryList(paramList, additionalData);

        //do something with data
        List<Map<String, Object>> groupedData = new ArrayList<>();

        for (Map<String, Object> item : data) {
            // Cari grup yang sesuai
            Map<String, Object> group = null;
            for (Map<String, Object> g : groupedData) {
                if (g.get("kode_propinsi").equals(item.get("kode_propinsi")) &&
                        g.get("nama_propinsi").equals(item.get("nama_propinsi")) &&
                        g.get("kode_kabupaten").equals(item.get("kode_kabupaten")) &&
                        g.get("nama_kabupaten").equals(item.get("nama_kabupaten"))) {
                    group = g;
                    break;
                }
            }

            // Jika grup tidak ada, buat grup baru
            if (group == null) {
                group = new HashMap<>();
                group.put("kode_propinsi", item.get("kode_propinsi"));
                group.put("nama_propinsi", item.get("nama_propinsi"));
                group.put("kode_kabupaten", item.get("kode_kabupaten"));
                group.put("nama_kabupaten", item.get("nama_kabupaten"));
                group.put("item", new ArrayList<Map<String, Object>>());
                groupedData.add(group);
            }

            // Tambahkan item ke dalam grup yang sesuai
            List<Map<String, Object>> items = (List<Map<String, Object>>) group.get("item");
            Map<String, Object> newItem = new HashMap<>();
            newItem.put("kode_wilayah", item.get("kode_wilayah"));
            newItem.put("nama_wilayah", item.get("nama_wilayah"));
            newItem.put("kode_kantor", item.get("kode_kantor"));
            newItem.put("nama_pembina", item.get("nama_pembina"));
            newItem.put("nama_kantor", item.get("nama_kantor"));
            newItem.put("no_proyek", item.get("no_proyek"));
            newItem.put("nama_proyek", item.get("nama_proyek"));
            newItem.put("alamat_proyek", item.get("alamat_proyek"));
            newItem.put("total_tk", item.get("total_tk"));
            newItem.put("nilai_proyek", item.get("nilai_proyek"));
            newItem.put("nilai_iuran", item.get("nilai_iuran"));
            newItem.put("tgl_awal_proyek", item.get("tgl_awal_proyek"));
            newItem.put("tgl_akhir_proyek", item.get("tgl_akhir_proyek"));
            newItem.put("tgl_akhir_pemeliharaan", item.get("tgl_akhir_pemeliharaan"));
            newItem.put("sumber_pembiayaan", item.get("sumber_pembiayaan"));
            newItem.put("npp", item.get("npp"));
            newItem.put("nama_perusahaan", item.get("nama_perusahaan"));
            newItem.put("tgl_peserta", item.get("tgl_peserta"));

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
