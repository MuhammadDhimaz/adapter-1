package com.bpjstk.JSReport.controllers;


import com.bpjstk.JSReport.models.RequestModel;
import com.bpjstk.JSReport.models.ResponseBuilder;
import com.bpjstk.JSReport.services.encryptions.DecryptParamPropertyEditor;
import com.bpjstk.JSReport.services.encryptions.DecryptionService;
import com.bpjstk.JSReport.services.modules.KNOSSService;
import com.bpjstk.JSReport.services.utilities.UtilityService;
import com.bpjstk.JSReport.services.validations.KNOSSValidator;
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
@RequestMapping("/KNOSS")
public class KNOSSController extends ModuleController {
    private final KNOSSService knossService;
    private final KNOSSValidator knossValidator;

    @Autowired
    public KNOSSController(KNOSSService knossService, KNOSSValidator knossValidator, DecryptionService decryptionService, UtilityService utilityService) {
        super(decryptionService, utilityService);
        this.knossService = knossService;
        this.knossValidator = knossValidator;
    }

    @InitBinder("requestModel")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(knossValidator);
        binder.registerCustomEditor(String.class, new DecryptParamPropertyEditor(decryptionService));
    }

    @GetMapping("/005")
    public ResponseEntity<?> getKNOSS005(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knossValidator.validate(requestModel, bindingResult, "005");
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
            params.put("p_pembina", requestModel.getP_pembina());
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNOSS005",
                    p_user,
                    "Rincian OSS ITW ITB Per Pembina",
                    "",
                    blth,
                    periode);
            byte[] data = knossService.getKNOSS005(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }

    @GetMapping("/006")
    public ResponseEntity<?> getKNOSS006(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knossValidator.validate(requestModel, bindingResult, "006");
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
                    "KNOSS006",
                    p_user,
                    "Rekap OSS ITW ITB Per Cabang",
                    "",
                    blth,
                    periode);
            byte[] data = knossService.getKNOSS006(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }

    @GetMapping("/007")
    public ResponseEntity<?> getKNOSS007(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knossValidator.validate(requestModel, bindingResult, "007");
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
                    "KNOSS007",
                    p_user,
                    "Rekap OSS ITW ITB Per Wilayah",
                    "",
                    blth,
                    periode);
            byte[] data = knossService.getKNOSS007(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }

    @GetMapping("/008")
    public ResponseEntity<?> getKNOSS008(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knossValidator.validate(requestModel, bindingResult, "008");
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
                    "KNOSS008",
                    p_user,
                    "Rekap OSS ITW ITB Nasional",
                    "",
                    blth,
                    periode);
            byte[] data = knossService.getKNOSS008(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }
}
