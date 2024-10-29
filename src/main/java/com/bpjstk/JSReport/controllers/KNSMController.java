package com.bpjstk.JSReport.controllers;

import com.bpjstk.JSReport.models.RequestModel;
import com.bpjstk.JSReport.models.ResponseBuilder;
import com.bpjstk.JSReport.services.encryptions.DecryptParamPropertyEditor;
import com.bpjstk.JSReport.services.encryptions.DecryptionService;
import com.bpjstk.JSReport.services.modules.KNSMService;
import com.bpjstk.JSReport.services.utilities.UtilityService;
import com.bpjstk.JSReport.services.validations.KNSMValidator;
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
@RequestMapping("/KNSM")
public class KNSMController extends ModuleController {
    private final KNSMService knsmService;
    private final KNSMValidator knsmValidator;

    @Autowired
    public KNSMController(KNSMService knsmService, KNSMValidator knsmValidator, DecryptionService decryptionService, UtilityService utilityService) {
        super(decryptionService, utilityService);
        this.knsmService = knsmService;
        this.knsmValidator = knsmValidator;
    }

    @InitBinder("requestModel")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(knsmValidator);
        binder.registerCustomEditor(String.class, new DecryptParamPropertyEditor(decryptionService));
    }

    @GetMapping("/013")
    public ResponseEntity<?> getKNSM013(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knsmValidator.validate(requestModel, bindingResult, "013");
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
            params.put("p_kode_mitra", requestModel.getP_mitra());
            params.put("p_kode_kantor", requestModel.getP_kantor());
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNSM013",
                    p_user,
                    "Rincian Detail PU Mitra",
                    "",
                    blth,
                    periode);
            byte[] data = knsmService.getKNSM013(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/015")
    public ResponseEntity<?> getKNSM015(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knsmValidator.validate(requestModel, bindingResult, "015");
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
            params.put("p_kode_kolektor", requestModel.getP_kolektor());
            params.put("p_kode_kantor", requestModel.getP_kantor());
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNSM015",
                    p_user,
                    "Rincian Detail PU Kolektor",
                    "",
                    blth,
                    periode);
            byte[] data = knsmService.getKNSM015(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));
        }
    }
}
