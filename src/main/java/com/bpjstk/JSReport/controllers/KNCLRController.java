package com.bpjstk.JSReport.controllers;

import com.bpjstk.JSReport.models.RequestModel;
import com.bpjstk.JSReport.models.ResponseBuilder;
import com.bpjstk.JSReport.services.encryptions.DecryptParamPropertyEditor;
import com.bpjstk.JSReport.services.encryptions.DecryptionService;
import com.bpjstk.JSReport.services.modules.KNCLRService;
import com.bpjstk.JSReport.services.utilities.UtilityService;
import com.bpjstk.JSReport.services.validations.KNCLRValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/KNCLR")
public class KNCLRController extends ModuleController {
    private final KNCLRService knclrService;
    private final KNCLRValidator knclrValidator;

    @Autowired
    public KNCLRController(KNCLRService knclrService, KNCLRValidator knclrValidator, DecryptionService decryptionService, UtilityService utilityService) {
        super(decryptionService, utilityService);
        this.knclrService = knclrService;
        this.knclrValidator = knclrValidator;
    }

    @InitBinder("requestModel")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(knclrValidator);
        binder.registerCustomEditor(String.class, new DecryptParamPropertyEditor(decryptionService));
    }

    @GetMapping("/00001")
    public ResponseEntity<?> getKNCLR00001(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knclrValidator.validate(requestModel, bindingResult, "KNCLR00001");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            LocalDateTime now = LocalDateTime.now();
            String periode = now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_kode_kantor", requestModel.getP_kantor());
            params.put("p_periode", periode);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("", utilityService.getJsreportRecipe(acceptHeader), "KNCLR00001", p_user, "Rekapitulasi Clearance Nasional (Transaksional)", "", blth, periode);
            byte[] data = knclrService.getKNCLR00001(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));
        }
    }

    @GetMapping("/00003")
    public ResponseEntity<?> getKNCLR00003(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knclrValidator.validate(requestModel, bindingResult, "KNCLR00003");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            LocalDateTime now = LocalDateTime.now();
            String periode = now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_kode_wilayah", requestModel.getP_wilayah());
            params.put("p_periode", periode);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("", utilityService.getJsreportRecipe(acceptHeader), "KNCLR00003", p_user, "Rekapitulasi Clearance Kantor Wilayah (Transaksional)", "", blth, periode);
            byte[] data = knclrService.getKNCLR00003(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));
        }
    }

    @GetMapping("/00005")
    public ResponseEntity<?> getKNCLR00005(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knclrValidator.validate(requestModel, bindingResult, "KNCLR00005");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            LocalDateTime now = LocalDateTime.now();
            String periode = now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_kode_kantor", requestModel.getP_kantor());
            params.put("p_periode", periode);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("", utilityService.getJsreportRecipe(acceptHeader), "KNCLR00005", p_user, "Rekapitulasi Clearance Kantor Cabang", "", blth, periode);
            byte[] data = knclrService.getKNCLR00005(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));
        }
    }

    @GetMapping("/00008")
    public ResponseEntity<?> getKNCLR00008(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knclrValidator.validate(requestModel, bindingResult, "KNCLR00008");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            LocalDateTime now = LocalDateTime.now();
            String periode = now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_kode_kantor", requestModel.getP_kantor());
            params.put("p_pembina", requestModel.getP_pembina());
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("", utilityService.getJsreportRecipe(acceptHeader), "KNCLR00008", p_user, "PDS Tenaga Kerja", "", blth, periode);
            byte[] data = knclrService.getKNCLR00008(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));
        }
    }

    @GetMapping("/00009")
    public ResponseEntity<?> getKNCLR00009(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knclrValidator.validate(requestModel, bindingResult, "KNCLR00009");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            LocalDateTime now = LocalDateTime.now();
            String periode = now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_pembina", requestModel.getP_pembina());
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("", utilityService.getJsreportRecipe(acceptHeader), "KNCLR00009", p_user, "PDS Upah", "", blth, periode);
            byte[] data = knclrService.getKNCLR00009(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));
        }
    }

    @GetMapping("/00011")
    public ResponseEntity<?> getKNCLR00011(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knclrValidator.validate(requestModel, bindingResult, "KNCLR00011");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            LocalDateTime now = LocalDateTime.now();
            String periode = now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_kode_kantor", requestModel.getP_kantor());
            params.put("p_pembina", requestModel.getP_pembina());
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("", utilityService.getJsreportRecipe(acceptHeader), "KNCLR00011", p_user, "PDS Program", "", blth, periode);
            byte[] data = knclrService.getKNCLR00011(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));
        }
    }
}
