package com.bpjstk.JSReport.controllers;

import com.bpjstk.JSReport.models.RequestModel;
import com.bpjstk.JSReport.models.ResponseBuilder;
import com.bpjstk.JSReport.services.encryptions.DecryptParamPropertyEditor;
import com.bpjstk.JSReport.services.encryptions.DecryptionService;
import com.bpjstk.JSReport.services.modules.KNRService;
import com.bpjstk.JSReport.services.utilities.UtilityService;
import com.bpjstk.JSReport.services.validations.KNRValidator;
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
@RequestMapping("/KNR")
public class KNRController extends ModuleController {
    private final KNRService knrService;
    private final KNRValidator knrValidator;

    @Autowired
    public KNRController(KNRService knrService, KNRValidator knrValidator, DecryptionService decryptionService,
                         UtilityService utilityService) {
        super(decryptionService, utilityService);
        this.knrService = knrService;
        this.knrValidator = knrValidator;
    }

    @InitBinder("requestModel")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(knrValidator);
        binder.registerCustomEditor(String.class, new DecryptParamPropertyEditor(decryptionService));
    }

    @GetMapping("/1043")
    public ResponseEntity<?> getKNR1043(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "1043");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_periode", periode);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR1043",
                    p_user,
                    "Rekapitulasi PK/BU Per Segmen Kepesertaan",
                    "",
                    blth,
                    periode);
            byte[] data = knrService.getKNR1043(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));
        }
    }

    @GetMapping("/1050")
    public ResponseEntity<?> getKNR1050(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "1050");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String p_provinsi = requestModel.getP_provinsi();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_periode", periode);
            params.put("p_provinsi", p_provinsi);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR1050",
                    p_user,
                    "Rekap Kepesertaan Non-ASN",
                    "",
                    blth,
                    periode);
            byte[] data = knrService.getKNR1050(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));
        }
    }

    @GetMapping("/1051")
    public ResponseEntity<?> getKNR1051(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "1051");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String p_kabupaten = requestModel.getP_kabupaten();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_periode", periode);
            params.put("p_kabupaten", p_kabupaten);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "KNR1051", p_user,
                    "Daftar Kepesertaan Non-ASN Per Kabupaten/Kota", "", blth, periode);
            byte[] data = knrService.getKNR1051(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/1052A")
    public ResponseEntity<?> getKNR1052A(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "1052A");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String p_kantor = requestModel.getP_kantor();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_kantor", p_kantor);
            params.put("p_periode", periode);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "KNR1052A", p_user,
                    "Daftar Kepesertaan Non-ASN Per Kantor Cabang (Aktif)", "", blth, periode);
            byte[] data = knrService.getKNR1052A(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/1052NA")
    public ResponseEntity<?> getKNR1052NA(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "1052NA");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String p_kantor = requestModel.getP_kantor();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_kantor", p_kantor);
            params.put("p_periode", periode);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR1052NA",
                    p_user,
                    "Daftar Kepesertaan Non-ASN Per Kantor Cabang (Non-Aktif)",
                    "",
                    blth,
                    periode);
            byte[] data = knrService.getKNR1052NA(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/1111")
    public ResponseEntity<?> getKNR1111(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "1111");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String p_kantor = requestModel.getP_kantor();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_kantor", p_kantor);
            params.put("p_periode", periode);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR1111",
                    p_user,
                    "Akumulasi Kepesertaan Aktif Dan Non Aktif PU",
                    "",
                    blth,
                    periode);
            byte[] data = knrService.getKNR1111(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/2203")
    public ResponseEntity<?> getKNR2203(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "2203");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String p_kode_wilayah = requestModel.getP_wilayah();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_kode_wilayah", p_kode_wilayah);
            params.put("p_periode", periode);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR2203",
                    p_user,
                    "REKAP TENAGA KERJA BARU PENERIMA UPAH PER KANTOR CABANG",
                    "",
                    blth,
                    periode);
            byte[] data = knrService.getKNR2203(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/2204")
    public ResponseEntity<?> getKNR2204(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "2204");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_periode", periode);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR2204",
                    p_user,
                    "Rekapitulasi TK Baru Nasional (Historical)",
                    "",
                    blth,
                    periode);
            byte[] data = knrService.getKNR2204(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }

    @GetMapping("/8801B")
    public ResponseEntity<?> getKNR8801B(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "8801B");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_kode_kantor", requestModel.getP_kode_kantor());
            params.put("p_kantor", requestModel.getP_kantor());
            params.put("p_pembina", requestModel.getP_pembina());
            params.put("p_periode", periode);
            params.put("p_role", requestModel.getP_role());
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR8801B",
                    p_user,
                    "Monitoring Relationship Officer Historical",
                    "",
                    blth,
                    periode);
            byte[] data = knrService.getKNR8801B(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/903056C")
    public ResponseEntity<?> getKNR903056C(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "903056C");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_kode_kantor", requestModel.getP_kantor());
            params.put("p_blth_proses", periode);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR903056C",
                    p_user,
                    "REKAP TK AKTIF PU BERDASARKAN KANAL DAFTAR DAN SKALA USAHA CABANG PER PEMBINA",
                    "",
                    blth,
                    periode);
            byte[] data = knrService.getKNR903056C(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/903057C")
    public ResponseEntity<?> getKNR903057C(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "903057C");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_kode_kantor", requestModel.getP_kantor());
            params.put("p_blth_proses", periode);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR903057C",
                    p_user,
                    "REKAPITULASI PK/BU AKTIF BERDASARKAN KANAL DAFTAR & SKALA USAHA",
                    "",
                    blth,
                    periode);
            byte[] data = knrService.getKNR903057C(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/903057N")
    public ResponseEntity<?> getKNR903057N(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "903057N");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_blth_proses", periode);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR903057N",
                    p_user,
                    "REKAPITULASI PK/BU AKTIF BERDASARKAN KANAL DAFTAR & SKALA USAHA",
                    "",
                    blth,
                    periode);
            byte[] data = knrService.getKNR903057N(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/903057W")
    public ResponseEntity<?> getKNR903057W(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "903057W");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_blth_proses", periode);
            params.put("p_kode_wilayah", requestModel.getP_wilayah());
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR903057W",
                    p_user,
                    "REKAPITULASI PK/BU AKTIF BERDASARKAN KANAL DAFTAR & SKALA USAHA",
                    "",
                    blth,
                    periode);
            byte[] data = knrService.getKNR903057W(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/5402")
    public ResponseEntity<?> getKNR5402(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "5402");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String segmen = requestModel.getP_segmen();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_tgl_proses", periode);
            params.put("p_kode_segmen", segmen);
            params.put("p_kode_kantor", requestModel.getP_kantor());
            params.put("p_pembina", requestModel.getP_pembina());
            params.put("p_npp", requestModel.getP_npp());
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR5402",
                    p_user,
                    "REKAP PESERTA NA PROGRAM JHT BELUM KLAIM SALDO TERTENTU",
                    segmen,
                    blth,
                    periode);
            byte[] data = knrService.getKNR5402(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/1003")
    public ResponseEntity<?> getKNR1003(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "1003");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String periode2 = requestModel.getP_periode2();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_user", p_user);
            params.put("p_periode", periode);
            params.put("p_periode2", periode2);
            params.put("p_kode_kantor", requestModel.getP_kantor());

            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR1003",
                    p_user,
                    "REKAPITULASI PENERIMAAN IURAN PENERIMA UPAH KANTOR WILAYAH (HISTORICAL)",
                    periode2,
                    blth,
                    periode);
            byte[] data = knrService.getKNR1003(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/1004")
    public ResponseEntity<?> getKNR1004(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "1004");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String periode2 = requestModel.getP_periode2();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_user", p_user);
            params.put("p_periode", periode);
            params.put("p_periode2", periode2);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR1004",
                    p_user,
                    "REKAPITULASI PENERIMAAN IURAN PENERIMA UPAH KANTOR PUSAT (HISTORICAL)",
                    periode2,
                    blth,
                    periode);
            byte[] data = knrService.getKNR1004(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/1006")
    public ResponseEntity<?> getKNR1006(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "1006");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            params.put("p_user", p_user);
            params.put("p_kode_wilayah", requestModel.getP_wilayah());
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR1006",
                    p_user,
                    "DAFTAR IURAN BELUM RINCI KANTOR WILAYAH (TRANSAKSIONAL)",
                    "",
                    "",
                    "");
            byte[] data = knrService.getKNR1006(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/1007")
    public ResponseEntity<?> getKNR1007(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "1007");
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
                    "KNR1007",
                    p_user,
                    "DAFTAR IURAN BELUM RINCI KANTOR PUSAT (TRANSAKSIONAL)",
                    "",
                    blth,
                    periode);
            byte[] data = knrService.getKNR1007(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/3438")
    public ResponseEntity<?> getKNR3438(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "3438");
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
                    "KNR3438",
                    p_user,
                    "REKAPITULASI VALIDITAS NPWP BU DAN NIK TENAGA KERJA PER NASIONAL (TRANSAKSIONAL)",
                    "",
                    blth,
                    periode);
            byte[] data = knrService.getKNR3438(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/3440")
    public ResponseEntity<?> getKNR3440(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "3440");
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
                    "KNR3440",
                    p_user,
                    "",
                    "",
                    blth,
                    periode);
            byte[] data = knrService.getKNR3440(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/3444")
    public ResponseEntity<?> getKNR3444(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "3444");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String periode = requestModel.getP_periode();
            String blth = requestModel.getP_periode2();
            String p_user = requestModel.getP_user();
            params.put("p_kode_kantor", requestModel.getP_kantor());
            params.put("p_periode1", periode);
            params.put("p_periode2", blth);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR3444",
                    p_user,
                    "REKAP KOREKSI TENAGA KERJA PER NPP",
                    "",
                    blth,
                    periode);
            byte[] data = knrService.getKNR3444(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/903056N")
    public ResponseEntity<?> getKNR903056N(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "903056N");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            String p_user = requestModel.getP_user();
            params.put("p_periode2", periode);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR903056N",
                    p_user,
                    "REKAPITULASI TK AKTIF PU BERDASARKAN KANAL DAFTAR & SKALA USAHA NASIONAL PER WILAYAH",
                    "",
                    blth,
                    periode);
            byte[] data = knrService.getKNR903056N(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/903056W")
    public ResponseEntity<?> getKNR903056W(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "903056W");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            String p_user = requestModel.getP_user();
            params.put("p_kode_wilayah", requestModel.getP_wilayah());
            params.put("p_periode2", periode);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR903056W",
                    p_user,
                    "REKAPITULASI TK AKTIF PU BERDASARKAN KANAL DAFTAR & SKALA USAHA WILAYAH PER CABANG",
                    "",
                    blth,
                    periode);
            byte[] data = knrService.getKNR903056W(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/3506")
    public ResponseEntity<?> getKNR3506(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "3506");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String periode2 = requestModel.getP_periode2();
            String saldo = requestModel.getP_saldo();
            String saldo2 = requestModel.getP_saldo2();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_user", p_user);
            params.put("p_tgl_awal", periode);
            params.put("p_tgl_akhir", periode2);
            params.put("p_kode_segmen", requestModel.getP_segmen());
            params.put("p_npp", requestModel.getP_npp());
            params.put("p_saldo", requestModel.getP_saldo());
            params.put("p_saldo2", requestModel.getP_saldo2());
            params.put("p_konsolidasi", requestModel.getP_konsolidasi());
            params.put("p_kode_kantor", requestModel.getP_kantor());
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR3506",
                    p_user,
                    saldo,
                    periode2,
                    saldo2,
                    periode);
            byte[] data = knrService.getKNR3506(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/3507")
    public ResponseEntity<?> getKNR3507(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "3507");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String periode2 = requestModel.getP_periode2();
            String saldo = requestModel.getP_saldo();
            String saldo2 = requestModel.getP_saldo2();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_user", p_user);
            params.put("p_periode", periode);
            params.put("p_periode2", periode2);
            params.put("p_kode_segmen", requestModel.getP_segmen());
            params.put("p_npp", requestModel.getP_npp());
            params.put("p_saldo", requestModel.getP_saldo());
            params.put("p_saldo2", requestModel.getP_saldo2());
            params.put("p_konsolidasi", requestModel.getP_konsolidasi());
            params.put("p_kode_kantor", requestModel.getP_kantor());
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR3507",
                    p_user,
                    saldo,
                    periode2,
                    saldo2,
                    periode);
            byte[] data = knrService.getKNR3507(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/1001T")
    public ResponseEntity<?> getKNR1001T(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "1001T");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            String p_user = requestModel.getP_user();
            String subtitle = requestModel.getP_kantor();
            params.put("qktr", requestModel.getP_kantor());
            params.put("qkonsolidasi", requestModel.getP_konsolidasi());
            params.put("p_blth_proses", periode);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR1001T",
                    p_user,
                    "REKAPITULASI PENERIMAAN IURAN PU KANTOR CABANG/KCP",
                    subtitle,
                    blth,
                    periode);
            byte[] data = knrService.getKNR1001T(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/1021")
    public ResponseEntity<?> getKNR1021(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "1021");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            String p_user = requestModel.getP_user();
            params.put("p_role", requestModel.getP_role());
            params.put("p_kode_kantor", requestModel.getP_kantor());
            params.put("p_kode_ilo", requestModel.getP_kode_ilo());
            params.put("p_periode", periode);
            params.put("p_kode_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR1021",
                    p_user,
                    "DAFTAR PEMBERI KERJA/BADAN USAHA BINAAN PER PERMBINA",
                    "",
                    blth,
                    periode);
            byte[] data = knrService.getKNR1021(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/1022")
    public ResponseEntity<?> getKNR1022(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "1022");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_kode_user", p_user);
            params.put("p_periode", periode);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR1022",
                    p_user,
                    "Rekapitulasi Pemberi Kerja/Badan Usaha Binaan Kantor Cabang",
                    "",
                    blth,
                    periode);
            byte[] data = knrService.getKNR1022(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/1023")
    public ResponseEntity<?> getKNR1023(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "1023");
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
            params.put("p_kode_wilayah", requestModel.getP_wilayah());
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR1023",
                    p_user,
                    "Rekap Perusahaan Binaan",
                    "",
                    blth,
                    periode);
            byte[] data = knrService.getKNR1023(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/1024")
    public ResponseEntity<?> getKNR1024(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "1024");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_user", p_user);
            params.put("p_tgl_akhir", periode);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR1024",
                    p_user,
                    "Rekapitulasi Pemberi Kerja/Badan Usaha Binaan Kantor Pusat (Historical)",
                    "",
                    blth,
                    periode);
            byte[] data = knrService.getKNR1024(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/1025")
    public ResponseEntity<?> getKNR1025(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "1025");
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
            params.put("p_role", requestModel.getP_role());
            params.put("p_konsolidasi", requestModel.getP_konsolidasi());
            params.put("p_kode_kantor", requestModel.getP_kantor());
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR1025",
                    p_user,
                    "Rekapitulasi TK Baru",
                    "",
                    blth,
                    periode);
            byte[] data = knrService.getKNR1025(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/1040")
    public ResponseEntity<?> getKNR1040(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "1040");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_user", p_user);
            params.put("p_badan_hukum", requestModel.getP_badan_hukum());
            params.put("p_kode_kantor", requestModel.getP_kantor());
            params.put("p_pembina", requestModel.getP_pembina());
            params.put("p_periode", periode);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR1040",
                    p_user,
                    "Daftar PK/BU Berdasarkan Segmen Kepesertaan",
                    "",
                    blth,
                    periode);
            byte[] data = knrService.getKNR1040(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/1041")
    public ResponseEntity<?> getKNR1041(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "1041");
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
                    "KNR1041",
                    p_user,
                    "Rekapitulasi PK/BU Per Pembina Per Segmen Kepesertaan",
                    "",
                    blth,
                    periode);
            byte[] data = knrService.getKNR1041(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/1042")
    public ResponseEntity<?> getKNR1042(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "1042");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_user", p_user);
            params.put("p_kode_wilayah", requestModel.getP_wilayah());
            params.put("p_periode", periode);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR1042",
                    p_user,
                    "Rekapitulasi PK/BU Per Kantor Cabang Per Segmen Kepesertaan",
                    "",
                    blth,
                    periode);
            byte[] data = knrService.getKNR1042(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/1402")
    public ResponseEntity<?> getKNR1402(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "1402");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            String p_user = requestModel.getP_user();
            params.put("p_konsolidasi", requestModel.getP_konsolidasi());
            params.put("p_kode_kantor", requestModel.getP_kantor());
            params.put("p_periode", periode);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR1402",
                    p_user,
                    "REKAPITULASI PEMBERI KERJA/BADAN USAHA TEPAT WAKTU ( CABANG )",
                    "",
                    blth,
                    periode);
            byte[] data = knrService.getKNR1402(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/1410")
    public ResponseEntity<?> getKNR1410(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "1410");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            String p_user = requestModel.getP_user();
            String subtitle = requestModel.getP_kantor();
            params.put("p_kode_kantor", requestModel.getP_kantor());
            params.put("p_periode", periode);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR1410",
                    p_user,
                    "REKAP PENCETAKAN SERTIFIKAT PK/BU KCP/KACAB",
                    subtitle,
                    blth,
                    periode);
            byte[] data = knrService.getKNR1410(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/1411")
    public ResponseEntity<?> getKNR1411(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "1411");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            String p_user = requestModel.getP_user();
            String subtitle = requestModel.getP_kantor();
            params.put("p_kode_wilayah", requestModel.getP_wilayah());
            params.put("p_periode", periode);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR1411",
                    p_user,
                    "REKAPITULASI PENCETAKAN SERTIFIKAT BADAN USAHA KANTOR WILAYAH",
                    subtitle,
                    blth,
                    periode);
            byte[] data = knrService.getKNR1411(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/1412")
    public ResponseEntity<?> getKNR1412(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "1412");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            String p_user = requestModel.getP_user();
            params.put("p_user", p_user);
            params.put("p_periode", periode);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR1412",
                    p_user,
                    "REKAPITULASI PENCETAKAN SERTIFIKAT BADAN USAHA NASIONAL",
                    "",
                    blth,
                    periode);
            byte[] data = knrService.getKNR1412(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/2202")
    public ResponseEntity<?> getKNR2202(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "2202");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String subtitle = requestModel.getP_kantor();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_user", p_user);
            params.put("p_periode", periode);
            params.put("qktr", requestModel.getP_kantor());
            params.put("qkonsolidasi", requestModel.getP_konsolidasi());
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR2202",
                    p_user,
                    "REKAPITULASI TENAGA KERJA BARU PENERIMA UPAH PER PEMBINA",
                    subtitle,
                    blth,
                    periode);
            byte[] data = knrService.getKNR2202(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/3329CSYR")
    public ResponseEntity<?> getKNR3329CSYR(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "3329CSYR");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_user", p_user);
            params.put("p_tgl_laporan", periode);
            params.put("p_kode_kantor", requestModel.getP_kantor());
            params.put("p_kode_segmen", requestModel.getP_segmen());

            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR3329CSYR",
                    p_user,
                    "REKAPITULASI KEPESERTAAN LAYANAN SYARIAH KANTOR CABANG",
                    "",
                    blth,
                    periode);
            byte[] data = knrService.getKNR3329CSYR(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/3329NSYR")
    public ResponseEntity<?> getKNR3329NSYR(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "3329NSYR");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            String p_user = requestModel.getP_user();
            params.put("p_user", p_user);
            params.put("p_tgl_laporan", periode);
            params.put("p_kode_segmen", requestModel.getP_segmen());
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR3329NSYR",
                    p_user,
                    "REKAPITULASI KEPESERTAAN LAYANAN SYARIAH KANTOR PUSAT",
                    "",
                    blth,
                    periode);
            byte[] data = knrService.getKNR3329NSYR(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/3329PSYR")
    public ResponseEntity<?> getKNR3329PSYR(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "3329PSYR");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_user", p_user);
            params.put("p_tgl_laporan", periode);
            params.put("p_kode_segmen", requestModel.getP_segmen());
            params.put("p_pembina", requestModel.getP_pembina());
            params.put("p_kantor", requestModel.getP_kantor());
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR3329PSYR",
                    p_user,
                    "REKAPITULASI KEPESERTAAN LAYANAN SYARIAH PER PEMBINA",
                    "",
                    blth,
                    periode);
            byte[] data = knrService.getKNR3329PSYR(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/3329WSYR")
    public ResponseEntity<?> getKNR3329WSYR(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "3329WSYR");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_user", p_user);
            params.put("p_tgl_laporan", periode);
            params.put("p_kode_segmen", requestModel.getP_segmen());
            params.put("p_kantor", requestModel.getP_kantor());
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR3329WSYR",
                    p_user,
                    "REKAPITULASI KEPESERTAAN LAYANAN SYARIAH KANTOR WILAYAH",
                    "",
                    blth,
                    periode);
            byte[] data = knrService.getKNR3329WSYR(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/3428H")
    public ResponseEntity<?> getKNR3428H(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        knrValidator.validate(requestModel, bindingResult, "3428H");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_user", p_user);
            params.put("p_blth", periode);
            params.put("p_npp", requestModel.getP_npp());
            params.put("p_divisi", requestModel.getP_divisi());
            params.put("p_kode_kantor", requestModel.getP_kantor());
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNR3428H",
                    p_user,
                    "Laporan History Piutang Iuran",
                    "",
                    blth,
                    periode);
            byte[] data = knrService.getKNR3428H(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }
}
