package com.bpjstk.JSReport.controllers;


import com.bpjstk.JSReport.models.RequestModel;
import com.bpjstk.JSReport.models.ResponseBuilder;
import com.bpjstk.JSReport.services.encryptions.DecryptParamPropertyEditor;
import com.bpjstk.JSReport.services.encryptions.DecryptionService;
import com.bpjstk.JSReport.services.modules.MISRService;
import com.bpjstk.JSReport.services.utilities.UtilityService;
import com.bpjstk.JSReport.services.validations.MISRValidator;
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
@RequestMapping("/MISR")
public class MISRController extends ModuleController {
    private final MISRService misrService;
    private final MISRValidator misrValidator;

    @Autowired
    public MISRController(MISRService misrService, MISRValidator misrValidator, DecryptionService decryptionService, UtilityService utilityService) {
        super(decryptionService, utilityService);
        this.misrService = misrService;
        this.misrValidator = misrValidator;
    }


    @InitBinder("requestModel")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(misrValidator);
        binder.registerCustomEditor(String.class, new DecryptParamPropertyEditor(decryptionService));
    }

    @GetMapping("/1001")
    public ResponseEntity<?> getMISR1001(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        misrValidator.validate(requestModel, bindingResult, "1001");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            String kodeKantor = requestModel.getP_kantor();
            params.put("p_kode_kantor", kodeKantor);
            params.put("p_periode", periode);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "MISR1001",
                    p_user,
                    "Executive Summary Kepesertaan Cabang",
                    kodeKantor,
                    blth,
                    periode);
            byte[] data = misrService.getMISR1001(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));
        }

    }

    @GetMapping("/1002")
    public ResponseEntity<?> getMISR1002(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        misrValidator.validate(requestModel, bindingResult, "1002");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            String kodeKantor = requestModel.getP_kantor();
            params.put("p_kode_kantor", kodeKantor);
            params.put("p_periode", periode);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "MISR1002",
                    p_user,
                    "Executive Summary Kepesertaan Wilayah",
                    kodeKantor,
                    blth,
                    periode);
            byte[] data = misrService.getMISR1002(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }

    @GetMapping("/1003")
    public ResponseEntity<?> getMISR1003(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        misrValidator.validate(requestModel, bindingResult, "1003");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_periode", periode);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("", utilityService.getJsreportRecipe(acceptHeader), "MISR1003", p_user, "Executive Summary Kepesertaan Nasional", "", blth, periode);
            byte[] data = misrService.getMISR1003(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }

    @GetMapping("/1004")
    public ResponseEntity<?> getMISR1004(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        misrValidator.validate(requestModel, bindingResult, "1004");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            String kodeKantor = requestModel.getP_kantor();
            params.put("p_kode_kantor", kodeKantor);
            params.put("p_periode", periode);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("", utilityService.getJsreportRecipe(acceptHeader), "MISR1004", p_user, "Rekap Akuisisi TK Baru Smart Agent Nasional", kodeKantor, blth, periode);
            byte[] data = misrService.getMISR1004(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }

    @GetMapping("/1005")
    public ResponseEntity<?> getMISR1005(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        misrValidator.validate(requestModel, bindingResult, "1005");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String kodeSegmen = requestModel.getP_segmen();
            String kodeProgram = requestModel.getP_program();
            String kodeKantor = requestModel.getP_kantor();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_kode_kantor", kodeKantor);
            params.put("p_periode", periode);
            params.put("p_kode_segmen", kodeSegmen);
            params.put("p_program", kodeProgram);
            paramList.add(params);


            String subtitle = String.format("%s %s", kodeSegmen, kodeProgram);
            Map<String, String> additionalData = utilityService.createAdditionalData("", utilityService.getJsreportRecipe(acceptHeader), "MISR1005", p_user, "MUTASI DATA KEPESERTAAN", subtitle, blth, periode);
            byte[] data = misrService.getMISR1005(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }

    @GetMapping("/1006")
    public ResponseEntity<?> getMISR1006(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        misrValidator.validate(requestModel, bindingResult, "1006");
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
            params.put("p_kode_segmen", requestModel.getP_segmen());
            params.put("p_program", requestModel.getP_program());
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("", utilityService.getJsreportRecipe(acceptHeader), "MISR1006", p_user, "Mutasi Data Kepesertaan Wilayah", "", blth, periode);
            byte[] data = misrService.getMISR1006(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }

    @GetMapping("/1007")
    public ResponseEntity<?> getMISR1007(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        misrValidator.validate(requestModel, bindingResult, "MISR1007");
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
            params.put("p_segmen", requestModel.getP_segmen());
            params.put("p_program", requestModel.getP_program());
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "MISR1007",
                    p_user,
                    "Mutasi Data Kepesertaan Nasional",
                    "",
                    blth,
                    periode);
            byte[] data = misrService.getMISR1007(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }

    @GetMapping("/1008")
    public ResponseEntity<?> getMISR1008(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        misrValidator.validate(requestModel, bindingResult, "MISR1008");
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
            params.put("p_segmen", requestModel.getP_segmen());
            params.put("p_program", requestModel.getP_program());
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "", utilityService.getJsreportRecipe(acceptHeader),
                    "MISR1008",
                    p_user,
                    "Mutasi Data Kepesertaan KCI",
                    "",
                    blth,
                    periode);
            byte[] data = misrService.getMISR1008(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }

    @GetMapping("/1010")
    public ResponseEntity<?> getMISR1010(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        misrValidator.validate(requestModel, bindingResult, "MISR1010");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_periode", periode);
            params.put("p_segmen", requestModel.getP_segmen());
            params.put("p_kantor", requestModel.getP_kantor());
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "MISR1010",
                    p_user,
                    "Mutasi Data Kepesertaan Konsolidasi KCI",
                    "",
                    blth,
                    periode);
            byte[] data = misrService.getMISR1010(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }

    @GetMapping("/1011")
    public ResponseEntity<?> getMISR1011(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        misrValidator.validate(requestModel, bindingResult, "MISR1011");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            String p_user = requestModel.getP_user();
            params.put("p_user", p_user);
            params.put("p_periode", periode);
            params.put("p_kode_kantor", requestModel.getP_kantor());
            params.put("p_kode_segmen", requestModel.getP_segmen());
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "MISR1011",
                    p_user,
                    "Mutasi Data Kepesertaan Konsolidasi Wilayah",
                    "",
                    blth,
                    periode);
            byte[] data = misrService.getMISR1011(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }

    @GetMapping("/1012")
    public ResponseEntity<?> getMISR1012(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        misrValidator.validate(requestModel, bindingResult, "MISR1012");
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
            params.put("p_kode_segmen", requestModel.getP_segmen());
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "", utilityService.getJsreportRecipe(acceptHeader),
                    "MISR1012",
                    p_user,
                    "Mutasi Data Kepesertaan Konsolidasi Nasional",
                    "",
                    blth,
                    periode);
            byte[] data = misrService.getMISR1012(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }


}
