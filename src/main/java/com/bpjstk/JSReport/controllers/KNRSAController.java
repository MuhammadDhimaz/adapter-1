package com.bpjstk.JSReport.controllers;


import com.bpjstk.JSReport.models.RequestModel;
import com.bpjstk.JSReport.models.ResponseBuilder;
import com.bpjstk.JSReport.services.encryptions.DecryptParamPropertyEditor;
import com.bpjstk.JSReport.services.encryptions.DecryptionService;
import com.bpjstk.JSReport.services.modules.KNRSAService;
import com.bpjstk.JSReport.services.utilities.UtilityService;
import com.bpjstk.JSReport.services.validations.KNRSAValidator;
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
@RequestMapping("/KNRSA")
public class KNRSAController extends ModuleController {
    private final KNRSAService knrsaService;
    private final KNRSAValidator knrsaValidator;

    @Autowired
    public KNRSAController(KNRSAService knrsaService, KNRSAValidator knrsaValidator, DecryptionService decryptionService, UtilityService utilityService) {
        super(decryptionService, utilityService);
        this.knrsaService = knrsaService;
        this.knrsaValidator = knrsaValidator;
    }

    @InitBinder("requestModel")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(knrsaValidator);
        binder.registerCustomEditor(String.class, new DecryptParamPropertyEditor(decryptionService));
    }

    @GetMapping("/003")
    public ResponseEntity<?> getKNRSA003(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knrsaValidator.validate(requestModel, bindingResult, "003");
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

            Map<String, String> additionalData = utilityService.createAdditionalData("", utilityService.getJsreportRecipe(acceptHeader), "KNRSA003", p_user, "Rekap Akuisisi TK Baru Smart Agent Wilayah", "", blth, periode);
            byte[] data = knrsaService.getKNRSA003(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }

    @GetMapping("/004")
    public ResponseEntity<?> getKNRSA004(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knrsaValidator.validate(requestModel, bindingResult, "004");
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

            Map<String, String> additionalData = utilityService.createAdditionalData("", utilityService.getJsreportRecipe(acceptHeader), "KNRSA004", p_user, "Rekap Akuisisi TK Baru Smart Agent Nasional", "", blth, periode);
            byte[] data = knrsaService.getKNRSA004(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }


}
