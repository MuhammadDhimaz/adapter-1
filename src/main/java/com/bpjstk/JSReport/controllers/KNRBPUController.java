package com.bpjstk.JSReport.controllers;

import com.bpjstk.JSReport.models.PostData;
import com.bpjstk.JSReport.models.RequestModel;
import com.bpjstk.JSReport.models.ResponseBuilder;
import com.bpjstk.JSReport.services.encryptions.DecryptParamPropertyEditor;
import com.bpjstk.JSReport.services.encryptions.DecryptionService;
import com.bpjstk.JSReport.services.modules.KNRBPUService;
import com.bpjstk.JSReport.services.utilities.UtilityService;
import com.bpjstk.JSReport.services.validations.KNRBPUValidator;
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
@RequestMapping("/KNRBPU")
public class KNRBPUController extends ModuleController {
    private final KNRBPUService knrbpuService;
    private final KNRBPUValidator knrbpuValidator;


    @Autowired
    public KNRBPUController(KNRBPUService knrbpuService, KNRBPUValidator knrbpuValidator, DecryptionService decryptionService, UtilityService utilityService) {
        super(decryptionService, utilityService);
        this.knrbpuService = knrbpuService;
        this.knrbpuValidator = knrbpuValidator;
    }

    @InitBinder("requestModel")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(knrbpuValidator);
        binder.registerCustomEditor(String.class, new DecryptParamPropertyEditor(decryptionService));
    }

    @GetMapping("/0014")
    public ResponseEntity<?> getKNRBPU0014(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) {
        knrbpuValidator.validate(requestModel, bindingResult, "0014");
        if (bindingResult.hasErrors()) {
            return new ResponseBuilder().fail(bindingResult);
        } else {
            try {
                List<Map<String, String>> paramList = new ArrayList<>();
                Map<String, String> params = new HashMap<>();
                String periode = requestModel.getP_periode();
                String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
                String p_user = requestModel.getP_user();
                params.put("p_kantor", requestModel.getP_kantor());
                params.put("p_periode", requestModel.getP_periode());
                params.put("p_user", p_user);
                paramList.add(params);

                Map<String, String> additionalData = utilityService.createAdditionalData(
                        "",
                        utilityService.getJsreportRecipe(acceptHeader),
                        "KNRBPU0014",
                        p_user,
                        "REKAP TENAGA KERJA TEPAT WAKTU BAYAR IURAN WILAYAH",
                        "",
                        blth,
                        periode);
                byte[] data = knrbpuService.getKNRBPU0014(paramList, additionalData);

                return new ResponseBuilder().success(data, additionalData.get("recipe"));
            } catch (Exception error) {
                return new ResponseBuilder().fail(error);
            }
        }
    }

    @GetMapping("/0015")
    public ResponseEntity<?> getKNRBPU0015(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knrbpuValidator.validate(requestModel, bindingResult, "0015");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            String p_user = requestModel.getP_user();
            params.put("p_periode", periode);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNRBPU0015",
                    p_user,
                    "REKAP TENAGA KERJA TEPAT WAKTU BAYAR IURAN",
                    "",
                    blth,
                    periode);
            byte[] data = knrbpuService.getKNRBPU0015(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));
        }
    }

    @GetMapping("/0038")
    public ResponseEntity<?> getKNRBPU0038(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knrbpuValidator.validate(requestModel, bindingResult, "0038");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            String p_user = requestModel.getP_user();
            params.put("p_kantor", requestModel.getP_kantor());
            params.put("p_channel", requestModel.getP_channel());
            params.put("p_periode", periode);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNRBPU0038",
                    p_user,
                    "RINCIAN TENAGA KERJA AKTIF BPU TEPAT WAKTU",
                    "",
                    blth,
                    periode);
            byte[] data = knrbpuService.getKNRBPU0038(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }

    @GetMapping("/0039")
    public ResponseEntity<?> getKNRBPU0039(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        knrbpuValidator.validate(requestModel, bindingResult, "0039");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            String p_user = requestModel.getP_user();
            params.put("p_kantor", requestModel.getP_kantor());
            params.put("p_periode", periode);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "KNRBPU0039",
                    p_user,
                    "RINCIAN TENAGA KERJA AKTIF BPU TEPAT WAKTU",
                    "",
                    blth,
                    periode);
            byte[] data = knrbpuService.getKNRBPU0039(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }
}
