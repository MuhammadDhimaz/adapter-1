package com.bpjstk.JSReport.controllers;

import com.bpjstk.JSReport.models.RequestModel;
import com.bpjstk.JSReport.models.ResponseBuilder;
import com.bpjstk.JSReport.services.encryptions.DecryptParamPropertyEditor;
import com.bpjstk.JSReport.services.encryptions.DecryptionService;
import com.bpjstk.JSReport.services.modules.JNRService;
import com.bpjstk.JSReport.services.utilities.UtilityService;
import com.bpjstk.JSReport.services.validations.JNRValidator;
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
@RequestMapping("/JNR")
public class JNRController extends ModuleController {
    private final JNRValidator jnrValidator;
    private final JNRService jnrService;

    @Autowired
    public JNRController(JNRService jnrService, JNRValidator jnrValidator, DecryptionService decryptionService, UtilityService utilityService) {
        super(decryptionService, utilityService);
        this.jnrService = jnrService;
        this.jnrValidator = jnrValidator;
    }

    @InitBinder("requestModel")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(jnrValidator);
        binder.registerCustomEditor(String.class, new DecryptParamPropertyEditor(decryptionService));
    }

    @GetMapping("/3001")
    public ResponseEntity<?> getJNR3001(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        jnrValidator.validate(requestModel, bindingResult, "3001");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_kode_kantor", requestModel.getP_kantor());
            params.put("p_pembina", requestModel.getP_pembina());
            params.put("p_periode", periode);
            params.put("p_user", p_user);
            params.put("type", acceptHeader);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "JNR3001",
                    p_user,
                    "DAFTAR PROYEK AKTIF JASA KONSTRUKSI BNBA PER PEMBINA", "", blth, periode);
            byte[] data = jnrService.getJNR3001(paramList, additionalData);
            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }

    @GetMapping("/3002")
    public ResponseEntity<?> getJNR3002(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        jnrValidator.validate(requestModel, bindingResult, "3002");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_kode_kantor", requestModel.getP_kantor());
            params.put("p_periode", periode);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "JNR3002",
                    p_user,
                    "REKAP TK PROYEK AKTIF JASA KONSTRUKSI BNBA PER KACAB",
                    "",
                    blth,
                    periode);
            byte[] data = jnrService.getJNR3002(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }

    @GetMapping("/3003")
    public ResponseEntity<?> getJNR3003(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        jnrValidator.validate(requestModel, bindingResult, "3003");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_kode_kantor", requestModel.getP_kantor());
            params.put("p_no_proyek", requestModel.getP_no_proyek());
            params.put("p_periode", periode);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "JNR3003",
                    p_user,
                    "DAFTAR TK PROYEK JASA KONTRUKSI",
                    "",
                    blth,
                    periode
            );
            byte[] data = jnrService.getJNR3003(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/3004")
    public ResponseEntity<?> getJNR3004(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        jnrValidator.validate(requestModel, bindingResult, "3004");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_kode_kantor", requestModel.getP_kantor());
            params.put("p_periode", periode);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "JNR3004",
                    p_user,
                    "REKAP TK PROYEK AKTIF JAKONS PER KANWIL",
                    "",
                    blth,
                    periode
            );
            byte[] data = jnrService.getJNR3004(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/3005")
    public ResponseEntity<?> getJNR3005(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        jnrValidator.validate(requestModel, bindingResult, "3005");
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
                    "JNR3005",
                    p_user,
                    "REKAP TK PROYEK AKTIF JAKON NASIONAL",
                    "",
                    blth,
                    periode
            );
            byte[] data = jnrService.getJNR3005(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/3006")
    public ResponseEntity<?> getJNR3006(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        jnrValidator.validate(requestModel, bindingResult, "3006");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_kode_kabupaten = requestModel.getP_kabupaten();
            String p_kode_provinsi = requestModel.getP_provinsi();
            String p_npp = requestModel.getP_npp();
            String p_sumber_dana = requestModel.getP_sumber_dana();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_kode_kabupaten", p_kode_kabupaten);
            params.put("p_kode_provinsi", p_kode_provinsi);
            params.put("p_npp", p_npp);
            params.put("p_periode", periode);
            params.put("p_sumber_dana", p_sumber_dana);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "JNR3006",
                    p_user,
                    "DAFTAR PPROYEK AKTIF JASA KONTRUKSI PER KABUPATEN",
                    "",
                    blth,
                    periode
            );
            byte[] data = jnrService.getJNR3006(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

}