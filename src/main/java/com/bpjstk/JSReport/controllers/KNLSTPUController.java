package com.bpjstk.JSReport.controllers;

import com.bpjstk.JSReport.models.PostData;
import com.bpjstk.JSReport.models.RequestModel;
import com.bpjstk.JSReport.models.ResponseBuilder;
import com.bpjstk.JSReport.services.encryptions.DecryptParamPropertyEditor;
import com.bpjstk.JSReport.services.encryptions.DecryptionService;
import com.bpjstk.JSReport.services.modules.KNLSTPUService;
import com.bpjstk.JSReport.services.utilities.UtilityService;
import com.bpjstk.JSReport.services.validations.KNLSTPUValidator;
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
@RequestMapping("/KNLSTPU")
public class KNLSTPUController extends ModuleController {
    private final KNLSTPUService knlstpuService;
    private final KNLSTPUValidator knlstpuValidator;

    @Autowired
    public KNLSTPUController(KNLSTPUService knlstpuService, KNLSTPUValidator knlstpuValidator, DecryptionService decryptionService, UtilityService utilityService) {
        super(decryptionService, utilityService);
        this.knlstpuService = knlstpuService;
        this.knlstpuValidator = knlstpuValidator;
    }


    @InitBinder("requestModel")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(knlstpuValidator);
        binder.registerCustomEditor(String.class, new DecryptParamPropertyEditor(decryptionService));
    }

    @GetMapping("/022")
    public ResponseEntity<?> getKNLSTPU022(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knlstpuValidator.validate(requestModel, bindingResult, "022");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_kode_wilayah", requestModel.getP_wilayah());
            params.put("p_periode", periode);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNLSTPU022",
                    p_user,
                    "Report Per Pembina",
                    "",
                    blth,
                    periode);
            byte[] data = knlstpuService.getKNLSTPU022(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));
        }

    }

    @GetMapping("/023")
    public ResponseEntity<?> getKNLSTPU023(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knlstpuValidator.validate(requestModel, bindingResult, "023");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_kode_wilayah", requestModel.getP_wilayah());
            params.put("p_periode", periode);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNLSTPU023",
                    p_user,
                    "Report Per Pembina BPU",
                    "",
                    blth,
                    periode);
            byte[] data = knlstpuService.getKNLSTPU023(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));
        }

    }

    @GetMapping("/027")
    public ResponseEntity<?> getKNLSTPU027(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knlstpuValidator.validate(requestModel, bindingResult, "027");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_user", p_user);
            params.put("p_blth_proses", periode);
            params.put("p_kode_kantor", requestModel.getP_kantor());
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNLSTPU027",
                    p_user,
                    "Report Rincian Penambahan PK/BU Berdasarkan Jenis Usaha Cabang",
                    "",
                    blth,
                    periode);
            PostData data = knlstpuService.getKNLSTPU027(paramList, additionalData);

            return new ResponseBuilder().success(data);

        }

    }

    @GetMapping("/028")
    public ResponseEntity<?> getKNLSTPU028(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knlstpuValidator.validate(requestModel, bindingResult, "028");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_user", p_user);
            params.put("p_blth_proses", periode);
            params.put("p_kode_kantor", requestModel.getP_kantor());
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNLSTPU028",
                    p_user,
                    "Report Rincian Kepesertaan PK/BU Berdasarkan Jenis Usaha Cabang",
                    "",
                    blth,
                    periode);
            byte[] data = knlstpuService.getKNLSTPU028(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }

    @GetMapping("/029")
    public ResponseEntity<?> getKNLSTPU029(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knlstpuValidator.validate(requestModel, bindingResult, "029");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_user", p_user);
            params.put("p_blth_proses", periode);
            params.put("p_kode_kantor", requestModel.getP_kantor());
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNLSTPU029",
                    p_user,
                    "Report Rekapitulasi Kepesertaan Aktif Berdasarkan Jenis Usaha - Cabang",
                    "",
                    blth,
                    periode);
            byte[] data = knlstpuService.getKNLSTPU029(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }

    @GetMapping("/030")
    public ResponseEntity<?> getKNLSTPU030(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knlstpuValidator.validate(requestModel, bindingResult, "030");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_user", p_user);
            params.put("p_blth_proses", periode);
            params.put("p_kode_wilayah", requestModel.getP_wilayah());
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNLSTPU030",
                    p_user,
                    "Report Rekapitulasi Kepesertaan Aktif Berdasarkan Jenis Usaha - Wilayah",
                    "",
                    blth,
                    periode);
            byte[] data = knlstpuService.getKNLSTPU030(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }

    @GetMapping("/031")
    public ResponseEntity<?> getKNLSTPU031(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knlstpuValidator.validate(requestModel, bindingResult, "031");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_user", p_user);
            params.put("p_blth_proses", periode);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNLSTPU031",
                    p_user,
                    "Report Rekapitulasi Kepesertaan Aktif Berdasarkan Jenis Usaha - Nasional",
                    "",
                    blth,
                    periode);
            byte[] data = knlstpuService.getKNLSTPU031(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }
}
