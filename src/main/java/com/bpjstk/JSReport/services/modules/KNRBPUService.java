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
public class KNRBPUService extends ModuleService {

    @Autowired
    public KNRBPUService(DataService dataService) {
        super(dataService);
    }

    public byte[] getKNRBPU0014(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {

        //get Data from Impala
        List<Map<String, Object>> data = dataService.getImpalaDataByQueryList(paramList, additionalData);

        //do something with data
        List<Map<String, Object>> groupedData = new ArrayList<>();
        Map<String, Map<String, Object>> wilayahMap = new HashMap<>();

        for (Map<String, Object> item : data) {
            // Membentuk kunci wilayah berdasarkan kode_wilayah, nama_wilayah, dan persentase
            String wilayahKey = item.get("kode_wilayah") + "|" + item.get("nama_wilayah") + "|" + item.get("persentase");
            Map<String, Object> wilayahGroup = wilayahMap.get(wilayahKey);

            if (wilayahGroup == null) {
                // Jika grup wilayah belum ada, buat grup baru
                wilayahGroup = new HashMap<>();
                wilayahGroup.put("kode_wilayah", item.get("kode_wilayah"));
                wilayahGroup.put("nama_wilayah", item.get("nama_wilayah"));
                wilayahGroup.put("persentase", item.get("persentase"));
                wilayahGroup.put("kantors", new ArrayList<Map<String, Object>>());
                wilayahMap.put(wilayahKey, wilayahGroup);
                groupedData.add(wilayahGroup);
            }

            // Membentuk sub-grup kantor berdasarkan kode_kantor dan nama_kantor
            String kantorKey = item.get("kode_kantor") + "|" + item.get("nama_kantor");
            List<Map<String, Object>> kantors = (List<Map<String, Object>>) wilayahGroup.get("kantors");
            Map<String, Object> kantorGroup = kantors.stream()
                    .filter(k -> (k.get("kode_kantor") + "|" + k.get("nama_kantor")).equals(kantorKey))
                    .findFirst()
                    .orElse(null);

            if (kantorGroup == null) {
                // Jika sub-grup kantor belum ada, buat sub-grup baru
                kantorGroup = new HashMap<>();
                kantorGroup.put("kode_kantor", item.get("kode_kantor"));
                kantorGroup.put("nama_kantor", item.get("nama_kantor"));
                kantorGroup.put("item", new ArrayList<Map<String, Object>>());
                kantors.add(kantorGroup);
            }

            // Menambahkan item ke dalam sub-grup kantor
            List<Map<String, Object>> items = (List<Map<String, Object>>) kantorGroup.get("item");
            Map<String, Object> newItem = new HashMap<>();
            newItem.put("channel_bayar", item.get("channel_bayar"));
            newItem.put("jht", item.get("jht"));
            newItem.put("jkk", item.get("jkk"));
            newItem.put("jkm", item.get("jkm"));

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

    public byte[] getKNRBPU0015(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {

        // Mendapatkan data dari Impala
        List<Map<String, Object>> data = dataService.getImpalaDataByQueryList(paramList, additionalData);

        // List untuk menampung data yang sudah dikelompokkan
        List<Map<String, Object>> groupedData = new ArrayList<>();
        Map<String, Map<String, Object>> persentaseMap = new HashMap<>();

        // Mengambil data tanpa elemen terakhir, tetapi simpan elemen terakhir terpisah
        Map<String, Object> lastData = data.get(data.size() - 1);
        List<Map<String, Object>> filteredData = data.subList(0, data.size() - 1);

        // Proses pengelompokan
        for (Map<String, Object> item : filteredData) {
            // Membuat kunci berdasarkan nilai "persentase"
            String persentaseKey = String.valueOf(lastData.get("persentase"));
            Map<String, Object> persentaseGroup = persentaseMap.get(persentaseKey);

            // Jika grup persentase belum ada, buat baru
            if (persentaseGroup == null) {
                persentaseGroup = new HashMap<>();
                persentaseGroup.put("persentase", lastData.get("persentase"));
                persentaseGroup.put("persents", new ArrayList<Map<String, Object>>());
                persentaseMap.put(persentaseKey, persentaseGroup);
                groupedData.add(persentaseGroup);
            }

            // Membuat kunci berdasarkan wilayah
            String wilayahKey = item.get("kode_induk") + "|" + item.get("nama_wilayah");
            List<Map<String, Object>> persents = (List<Map<String, Object>>) persentaseGroup.get("persents");
            Map<String, Object> wilayahGroup = persents.stream()
                    .filter(p -> (p.get("kode_induk") + "|" + p.get("nama_wilayah")).equals(wilayahKey))
                    .findFirst()
                    .orElse(null);

            // Jika grup wilayah belum ada, buat baru
            if (wilayahGroup == null) {
                wilayahGroup = new HashMap<>();
                wilayahGroup.put("kode_induk", item.get("kode_induk"));
                wilayahGroup.put("nama_wilayah", item.get("nama_wilayah"));
                wilayahGroup.put("kantors", new ArrayList<Map<String, Object>>());
                persents.add(wilayahGroup);
            }

            // Membuat kunci berdasarkan kantor
            String kantorKey = item.get("kode_kantor") + "|" + item.get("nama_kantor");
            List<Map<String, Object>> kantors = (List<Map<String, Object>>) wilayahGroup.get("kantors");
            Map<String, Object> kantorGroup = kantors.stream()
                    .filter(k -> (k.get("kode_kantor") + "|" + k.get("nama_kantor")).equals(kantorKey))
                    .findFirst()
                    .orElse(null);

            // Jika grup kantor belum ada, buat baru
            if (kantorGroup == null) {
                kantorGroup = new HashMap<>();
                kantorGroup.put("kode_kantor", item.get("kode_kantor"));
                kantorGroup.put("nama_kantor", item.get("nama_kantor"));
                kantorGroup.put("item", new ArrayList<Map<String, Object>>());
                kantors.add(kantorGroup);
            }

            // Tambahkan item detail ke dalam grup kantor
            List<Map<String, Object>> items = (List<Map<String, Object>>) kantorGroup.get("item");
            Map<String, Object> newItem = new HashMap<>();
            newItem.put("via", item.get("via"));
            newItem.put("jht", item.get("jht"));
            newItem.put("jkk", item.get("jkk"));
            newItem.put("jkm", item.get("jkm"));
            items.add(newItem);
        }

        // Membuat objek PostData untuk dikirim ke JSReport
        PostData postData = new PostData(
                additionalData.get("queryId"),
                additionalData.get("p_user"),
                additionalData.get("title"),
                additionalData.get("subtitle"),
                additionalData.get("blth"),
                additionalData.get("periode"),
                groupedData
        );

        return dataService.getFileFromJSReport(new PostDataBuilder(additionalData.get("shortId"), additionalData.get("recipe"), postData));
    }


    public byte[] getKNRBPU0038(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {

        //get Data from Impala
        List<Map<String, Object>> data = dataService.getImpalaDataByQueryList(paramList, additionalData);

        //do something with data
        List<Map<String, Object>> groupedData = new ArrayList<>();
        Map<String, Map<String, Object>> wilayahMap = new HashMap<>();

        for (Map<String, Object> item : data) {
            // Buat kunci unik berdasarkan kode_kantor, nama_kantor, kode_ark, dan nama_ark
            String wilayahKey = item.get("kode_kantor") + "|" + item.get("nama_kantor") + "|" +
                    item.get("kode_ark") + "|" + item.get("nama_ark");

            Map<String, Object> wilayahGroup = wilayahMap.get(wilayahKey);

            if (wilayahGroup == null) {
                // Jika grup belum ada, buat grup baru
                wilayahGroup = new HashMap<>();
                wilayahGroup.put("kode_kantor", item.get("kode_kantor"));
                wilayahGroup.put("nama_kantor", item.get("nama_kantor"));
                wilayahGroup.put("kode_ark", item.get("kode_ark"));
                wilayahGroup.put("nama_ark", item.get("nama_ark"));
                wilayahGroup.put("item", new ArrayList<Map<String, Object>>());

                wilayahMap.put(wilayahKey, wilayahGroup);
                groupedData.add(wilayahGroup);
            }

            // Tambahkan item ke grup yang sudah ada
            List<Map<String, Object>> items = (List<Map<String, Object>>) wilayahGroup.get("item");
            Map<String, Object> newItem = new HashMap<>();
            newItem.put("nik", item.get("nik"));
            newItem.put("nama_tk", item.get("nama_tk"));
            newItem.put("tgl_lahir", item.get("tgl_lahir"));
            newItem.put("jht", item.get("jht"));
            newItem.put("jkk", item.get("jkk"));
            newItem.put("jkm", item.get("jkm"));
            newItem.put("tgl_berakhir", item.get("tgl_berakhir"));
            newItem.put("channel_daftar", item.get("channel_daftar"));
            newItem.put("via", item.get("via"));
            newItem.put("nomor_hp", item.get("nomor_hp"));
            newItem.put("valid_hp", item.get("valid_hp"));
            newItem.put("persentase", item.get("persentase"));

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

    public byte[] getKNRBPU0039(List<Map<String, String>> paramList, Map<String, String> additionalData) throws ExecutionException, InterruptedException {

        //get Data from Impala
        List<Map<String, Object>> data = dataService.getImpalaDataByQueryList(paramList, additionalData);

        //do something with data
        // Pastikan data tidak kosong
        if (data == null || data.isEmpty()) {
            return null; // atau lemparkan pengecualian sesuai kebutuhan
        }

        // Menyimpan elemen terakhir yang berisi data total dan persentase
        Map<String, Object> lastData = data.get(data.size() - 1);
        Double persentase = (Double) lastData.get("persentase");

        // Mengambil data tanpa elemen terakhir
        List<Map<String, Object>> filteredData = data.subList(0, data.size() - 1);

        // List untuk menampung data yang sudah dikelompokkan
        List<Map<String, Object>> groupedData = new ArrayList<>();
        Map<String, Map<String, Object>> wilayahMap = new HashMap<>();

        // Proses pengelompokan
        for (Map<String, Object> item : filteredData) {
            // Buat kunci unik berdasarkan kode_kantor dan nama_kantor
            String wilayahKey = item.get("kode_kantor") + "|" + item.get("nama_kantor");
            Map<String, Object> wilayahGroup = wilayahMap.get(wilayahKey);

            // Jika grup wilayah belum ada, buat baru
            if (wilayahGroup == null) {
                wilayahGroup = new HashMap<>();
                wilayahGroup.put("kode_kantor", item.get("kode_kantor"));
                wilayahGroup.put("nama_kantor", item.get("nama_kantor"));
                wilayahGroup.put("persentase", persentase);  // Masukkan persentase ke dalam wilayahGroup
                wilayahGroup.put("pembinas", new ArrayList<Map<String, Object>>());
                wilayahMap.put(wilayahKey, wilayahGroup);
                groupedData.add(wilayahGroup);
            }

            // Sub-grup untuk pembina berdasarkan kode_ark dan nama_ark
            String pembinaKey = item.get("kode_ark") + "|" + item.get("nama_ark");
            List<Map<String, Object>> pembinas = (List<Map<String, Object>>) wilayahGroup.get("pembinas");

            Map<String, Object> pembinaGroup = pembinas.stream()
                    .filter(p -> (p.get("kode_ark") + "|" + p.get("nama_ark")).equals(pembinaKey))
                    .findFirst()
                    .orElse(null);

            // Jika grup pembina belum ada, buat baru
            if (pembinaGroup == null) {
                pembinaGroup = new HashMap<>();
                pembinaGroup.put("kode_ark", item.get("kode_ark"));
                pembinaGroup.put("nama_ark", item.get("nama_ark"));
                pembinaGroup.put("item", new ArrayList<Map<String, Object>>());
                pembinas.add(pembinaGroup);
            }

            // Tambahkan item detail ke dalam grup pembina
            List<Map<String, Object>> items = (List<Map<String, Object>>) pembinaGroup.get("item");
            Map<String, Object> newItem = new HashMap<>();
            newItem.put("via", item.get("via"));
            newItem.put("jht", item.get("jht"));
            newItem.put("jkk", item.get("jkk"));
            newItem.put("jkm", item.get("jkm"));
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


