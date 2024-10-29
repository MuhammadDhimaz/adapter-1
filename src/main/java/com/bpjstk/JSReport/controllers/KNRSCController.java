package com.bpjstk.JSReport.controllers;


import com.bpjstk.JSReport.models.RequestModel;
import com.bpjstk.JSReport.models.ResponseBuilder;
import com.bpjstk.JSReport.services.encryptions.DecryptParamPropertyEditor;
import com.bpjstk.JSReport.services.encryptions.DecryptionService;
import com.bpjstk.JSReport.services.modules.KNRSCService;
import com.bpjstk.JSReport.services.utilities.UtilityService;
import com.bpjstk.JSReport.services.validations.KNRSCValidator;
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
@RequestMapping("/KNRSC")
public class KNRSCController extends ModuleController {
    private final KNRSCService knrscService;
    private final KNRSCValidator knrscValidator;

    @Autowired
    public KNRSCController(KNRSCService knrscService, KNRSCValidator knrscValidator, DecryptionService decryptionService, UtilityService utilityService) {
        super(decryptionService, utilityService);
        this.knrscService = knrscService;
        this.knrscValidator = knrscValidator;
    }

    @InitBinder("requestModel")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(knrscValidator);
        binder.registerCustomEditor(String.class, new DecryptParamPropertyEditor(decryptionService));
    }

    @GetMapping("/001")
    public ResponseEntity<?> getKNRSC001(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knrscValidator.validate(requestModel, bindingResult, "KNRSC001");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            try {
                List<Map<String, String>> paramList = new ArrayList<>();
                Map<String, String> params = new HashMap<>();
                String p_user = requestModel.getP_user();
                String periode = requestModel.getP_periode();
                String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
                params.put("p_kode_kantor", requestModel.getP_kantor());
                params.put("p_periode", periode);
                params.put("p_pembina", requestModel.getP_pembina());
                params.put("p_user", p_user);
                paramList.add(params);

                Map<String, String> additionalData = utilityService.createAdditionalData(
                        "",
                        utilityService.getJsreportRecipe(acceptHeader), "KNRSC001", p_user, "Title Example", "", blth, periode);
                byte[] data = knrscService.getKNRSC001(paramList, additionalData);

                return new ResponseBuilder().success(data, additionalData.get("recipe"));
            } catch (Exception error) {
                return new ResponseBuilder().fail(error);
            }
        }

    }

    @GetMapping("/021")
    public ResponseEntity<?> getKNRSC021(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knrscValidator.validate(requestModel, bindingResult, "KNRSC021");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            try {
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
                        utilityService.getJsreportRecipe(acceptHeader), "KNRSC021", p_user, "Title Example", "", blth, periode);
                byte[] data = knrscService.getKNRSC021(paramList, additionalData);

                return new ResponseBuilder().success(data, additionalData.get("recipe"));
            } catch (Exception error) {
                return new ResponseBuilder().fail(error);
            }
        }

    }

    @GetMapping("/024")
    public ResponseEntity<?> getKNRSC024(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knrscValidator.validate(requestModel, bindingResult, "KNRSC024");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            try {
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
                        utilityService.getJsreportRecipe(acceptHeader), "KNRSC024", p_user, "Title Example", "", blth, periode);
                byte[] data = knrscService.getKNRSC024(paramList, additionalData);

                return new ResponseBuilder().success(data, additionalData.get("recipe"));
            } catch (Exception error) {
                return new ResponseBuilder().fail(error);
            }
        }

    }


}
