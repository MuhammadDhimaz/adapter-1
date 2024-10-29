package com.bpjstk.JSReport.controllers;

import com.bpjstk.JSReport.models.RequestModel;
import com.bpjstk.JSReport.models.ResponseBuilder;
import com.bpjstk.JSReport.services.encryptions.DecryptParamPropertyEditor;
import com.bpjstk.JSReport.services.encryptions.DecryptionService;
import com.bpjstk.JSReport.services.modules.KNRSRService;
import com.bpjstk.JSReport.services.utilities.UtilityService;
import com.bpjstk.JSReport.services.validations.KNRSRValidator;
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
@RequestMapping("/KNRSR")
public class KNRSRController extends ModuleController {
    private final KNRSRService knrsrService;
    private final KNRSRValidator knrsrValidator;


    @Autowired
    public KNRSRController(KNRSRService knrsrService, KNRSRValidator knrsrValidator, DecryptionService decryptionService, UtilityService utilityService) {
        super(decryptionService, utilityService);
        this.knrsrService = knrsrService;
        this.knrsrValidator = knrsrValidator;
    }


    @InitBinder("requestModel")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(knrsrValidator);
        binder.registerCustomEditor(String.class, new DecryptParamPropertyEditor(decryptionService));
    }

    @GetMapping("/0021")
    public ResponseEntity<?> getKNRSR0021(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knrsrValidator.validate(requestModel, bindingResult, "0021");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String periode = requestModel.getP_periode1();
            String blth = requestModel.getP_periode2();
            String p_user = requestModel.getP_user();
            params.put("p_kode_perusahaan", requestModel.getP_perusahaan());
            params.put("p_periode1", periode);
            params.put("p_periode2", blth);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNRSR0021",
                    p_user,
                    "LAPORAN DIRECT COMMUNICATION BERDASARKAN PK/BU",
                    "",
                    blth,
                    periode);
            byte[] data = knrsrService.getKNRSR0021(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/0022")
    public ResponseEntity<?> getKNRSR0022(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knrsrValidator.validate(requestModel, bindingResult, "0022");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String periode = requestModel.getP_periode();
            String periode2 = requestModel.getP_periode2();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            String p_user = requestModel.getP_user();
            params.put("p_kd_tema", requestModel.getP_tema());
            params.put("p_periode", periode);
            params.put("p_periode2", periode2);
            params.put("p_pembina", requestModel.getP_pembina());
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNRSR0022",
                    p_user,
                    "LAPORAN DIRECT COMMUNICATON BERDASARKAN TEMA KOMUNIKASI",
                    periode2,
                    blth,
                    periode);
            byte[] data = knrsrService.getKNRSR0022(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/0023")
    public ResponseEntity<?> getKNRSR0023(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knrsrValidator.validate(requestModel, bindingResult, "0023");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String periode = requestModel.getP_periode();
            String periode2 = requestModel.getP_periode2();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            String p_user = requestModel.getP_user();
            params.put("p_kode_kantor", requestModel.getP_kantor());
            params.put("p_periode", periode);
            params.put("p_periode2", periode2);
            params.put("p_pembina", requestModel.getP_pembina());
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNRSR0023",
                    p_user,
                    "Laporan Direct Communication Berdasarkan Periode",
                    periode2,
                    blth,
                    periode);
            byte[] data = knrsrService.getKNRSR0023(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }
}

