package com.bpjstk.JSReport.controllers;

import com.bpjstk.JSReport.models.RequestModel;
import com.bpjstk.JSReport.models.ResponseBuilder;
import com.bpjstk.JSReport.services.encryptions.DecryptParamPropertyEditor;
import com.bpjstk.JSReport.services.encryptions.DecryptionService;
import com.bpjstk.JSReport.services.modules.KSARService;
import com.bpjstk.JSReport.services.utilities.UtilityService;
import com.bpjstk.JSReport.services.validations.KSARValidator;
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
@RequestMapping("/KSAR")
public class KSARController extends ModuleController {
    private final KSARService ksarService;
    private final KSARValidator ksarValidator;

    @Autowired
    public KSARController(KSARService ksarService, KSARValidator ksarValidator, DecryptionService decryptionService, UtilityService utilityService) {
        super(decryptionService, utilityService);
        this.ksarService = ksarService;
        this.ksarValidator = ksarValidator;
    }


    @InitBinder("requestModel")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(ksarValidator);
        binder.registerCustomEditor(String.class, new DecryptParamPropertyEditor(decryptionService));
    }

    @GetMapping("/107")
    public ResponseEntity<?> getKSAR107(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        ksarValidator.validate(requestModel, bindingResult, "107");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_kantor", requestModel.getP_kantor());
            params.put("p_periode", periode);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "KSAR107", p_user, "Detail Asosiasi/Komunitas", "", blth, periode);
//                PostData data = utilityService.getDataRaw(paramList, additionalData);
            byte[] data = ksarService.getKSAR107(paramList, additionalData);
            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/108")
    public ResponseEntity<?> getKSAR108(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        ksarValidator.validate(requestModel, bindingResult, "108");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_kantor", requestModel.getP_kantor());
            params.put("p_periode", periode);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "KSAR108", p_user, "Rekap Asosisasi/Komunitas", "", blth, periode);
            byte[] data = ksarService.getKSAR108(paramList, additionalData);
            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/109")
    public ResponseEntity<?> getKSAR109(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        ksarValidator.validate(requestModel, bindingResult, "109");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_kantor", requestModel.getP_kantor());
            params.put("p_periode", periode);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "", utilityService.getJsreportRecipe(acceptHeader),
                    "KSAR109",
                    p_user,
                    "Rekap Kepatuhan Asosiasi/Komunitas",
                    "",
                    blth, periode);
//                PostData data = utilityService.getDataRaw(paramList, additionalData);
            byte[] data = ksarService.getKSAR109(paramList, additionalData);
            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }
}