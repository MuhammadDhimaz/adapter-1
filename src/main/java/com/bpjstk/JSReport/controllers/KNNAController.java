package com.bpjstk.JSReport.controllers;

import com.bpjstk.JSReport.models.RequestModel;
import com.bpjstk.JSReport.models.ResponseBuilder;
import com.bpjstk.JSReport.services.encryptions.DecryptParamPropertyEditor;
import com.bpjstk.JSReport.services.encryptions.DecryptionService;
import com.bpjstk.JSReport.services.modules.KNNAService;
import com.bpjstk.JSReport.services.utilities.UtilityService;
import com.bpjstk.JSReport.services.validations.KNNAValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/KNNA")
public class KNNAController extends ModuleController{
    private final KNNAService knnaService;
    private final KNNAValidator knnaValidator;

    @Autowired
    public KNNAController(KNNAService knnaService, KNNAValidator knnaValidator, DecryptionService decryptionService, UtilityService utilityService) {
        super(decryptionService, utilityService);
        this.knnaService = knnaService;
        this.knnaValidator = knnaValidator;
        
    }

    @InitBinder("requestModel")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(knnaValidator);
        binder.registerCustomEditor(String.class, new DecryptParamPropertyEditor(decryptionService));
    }

    @GetMapping("/1003")
    public ResponseEntity<?> getKNNA1003(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knnaValidator.validate(requestModel, bindingResult, "1003");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_user", p_user);
            params.put("p_periode", periode);
            params.put("p_kantor", requestModel.getP_kantor());
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNNA1003",
                    p_user,
                    "REKAP JUMLAH PEKERJA NON ASN PER PEMBINA BERDASARKAN TINGKAT",
                    "",
                    blth,
                    periode);
            byte[] data = knnaService.getKNNA1003(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));
        }

    }

    @GetMapping("/1004")
    public ResponseEntity<?> getKNNA1004(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knnaValidator.validate(requestModel, bindingResult, "1004");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_user", p_user);
            params.put("p_periode", periode);
            params.put("p_kode_kantor", requestModel.getP_kantor());
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNNA1004",
                    p_user,
                    "Rekap Pekerja Non ASN Per Kab/Kota Berdasarkan Tingkat",
                    "",
                    blth,
                    periode);
            byte[] data = knnaService.getKNNA1004(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }

    @GetMapping("/1005")
    public ResponseEntity<?> getKNNA1005(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knnaValidator.validate(requestModel, bindingResult, "1005");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_user", p_user);
            params.put("p_periode", periode);
            params.put("p_kode_provinsi", requestModel.getP_provinsi());
            params.put("p_kode_kabupaten", requestModel.getP_kabupaten());
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNNA1005",
                    p_user,
                    "Rekap Pekerja Non ASN Per Provinsi Kab/Kota Berdasarkan Kategori Pekerja",
                    "",
                    blth,
                    periode);
            byte[] data = knnaService.getKNNA1005(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/1006")
    public ResponseEntity<?> getKNNA1006(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knnaValidator.validate(requestModel, bindingResult, "1006");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_kode_provinsi", requestModel.getP_provinsi());
            params.put("p_kode_kabupaten", requestModel.getP_kabupaten());
            params.put("p_periode", periode);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNNA1006",
                    p_user,
                    "REKAP JUMLAH PEKERJA NON ASN PER PROVINSI / KAB/KOTA BERDASARKAN KEMENTERIAN/LEMBAGA",
                    "",
                    blth,
                    periode);
            byte[] data = knnaService.getKNNA1006(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }

    @GetMapping("/1007")
    public ResponseEntity<?> getKNNA1007(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knnaValidator.validate(requestModel, bindingResult, "1007");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            String p_user = requestModel.getP_user();
            params.put("p_kantor", requestModel.getP_kantor());
            params.put("p_pembina", requestModel.getP_pembina());
            params.put("p_periode", periode);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNNA1007",
                    p_user,
                    "REKAP JUMLAH PEKERJA NON ASN PER PEMBINA",
                    "",
                    blth,
                    periode);
            byte[] data = knnaService.getKNNA1007(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }

    @GetMapping("/1008")
    public ResponseEntity<?> getKNNA1008(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knnaValidator.validate(requestModel, bindingResult, "1008");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            String p_user = requestModel.getP_user();
            params.put("p_kode_kantor", requestModel.getP_kantor());
            params.put("p_periode", periode);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNNA1008",
                    p_user,
                    "REKAP JUMLAH PEKERJA NON ASN PER PEMBINA BERDASARKAN TINGKAT",
                    "",
                    blth,
                    periode);
            byte[] data = knnaService.getKNNA1008(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }

    @GetMapping("/1009")
    public ResponseEntity<?> getKNNA1009(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knnaValidator.validate(requestModel, bindingResult, "1009");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_user", p_user);
            params.put("p_periode", periode);
            params.put("p_kode_kantor", requestModel.getP_kantor());
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNNA1009",
                    p_user,
                    "Rekap Pekerja Non ASN Per Kanwil",
                    "",
                    blth,
                    periode);
            byte[] data = knnaService.getKNNA1009(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }

    @GetMapping("/1010")
    public ResponseEntity<?> getKNNA1010(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knnaValidator.validate(requestModel, bindingResult, "1010");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_user", p_user);
            params.put("p_periode", periode);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNNA1010",
                    p_user,
                    "Rekap Pekerja Non ASN Nasional",
                    "",
                    blth,
                    periode);
            byte[] data = knnaService.getKNNA1010(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }

    @GetMapping("/1011")
    public ResponseEntity<?> getKNNA1011(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knnaValidator.validate(requestModel, bindingResult, "1011");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_user", p_user);
            params.put("p_kode_provinsi", requestModel.getP_provinsi());
            params.put("p_kode_kabupaten", requestModel.getP_kabupaten());
            params.put("p_kode_kementrian", requestModel.getP_kementrian());
            params.put("p_periode", periode);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNNA1011",
                    p_user,
                    "Rekap Pekerja Non ASN Per Kementerian/Lembaga",
                    "",
                    blth,
                    periode);
            byte[] data = knnaService.getKNNA1011(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }
}
