package com.bpjstk.JSReport.controllers;

import com.bpjstk.JSReport.models.PostData;
import com.bpjstk.JSReport.models.RequestModel;
import com.bpjstk.JSReport.models.ResponseBuilder;
import com.bpjstk.JSReport.services.encryptions.DecryptParamPropertyEditor;
import com.bpjstk.JSReport.services.encryptions.DecryptionService;
import com.bpjstk.JSReport.services.modules.GLRService;
import com.bpjstk.JSReport.services.utilities.UtilityService;
import com.bpjstk.JSReport.services.validations.GLRValidator;
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
@RequestMapping("/GLR")
public class GLRController extends ModuleController {
    private final GLRService glrService;
    private final GLRValidator glrValidator;

    @Autowired
    public GLRController(GLRService glrService, GLRValidator glrValidator, DecryptionService decryptionService,
                         UtilityService utilityService) {
        super(decryptionService, utilityService);
        this.glrService = glrService;
        this.glrValidator = glrValidator;
    }

    @InitBinder("requestModel")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(glrValidator);
        binder.registerCustomEditor(String.class, new DecryptParamPropertyEditor(decryptionService));
    }

    @GetMapping("/201908157")
    public ResponseEntity<?> getGLR201908157(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "201908157");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qtgl", periode);
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("qOEtmv1",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR201908157", quser, title, subtitle, blth,
                    periode);
            byte[] data = glrService.getGLR201908157(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/201908158")
    public ResponseEntity<?> getGLR201908158(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "201908158");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("p_kantor", requestModel.getQktr());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("U30fUZs",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR201908158", quser,
                    "LAPORAN REKAPITULASI BEBAN JAMINAN", subtitle, blth, periode);
            byte[] data = glrService.getGLR201908158(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/9120101")
    public ResponseEntity<?> getGLR9120101(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "9120101");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR9120101", quser, title, subtitle, blth,
                    periode);
            byte[] data = glrService.getGLR9120101(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/912010101")
    public ResponseEntity<?> getGLR912010101(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "912010101");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR912010101", quser, title, subtitle, blth,
                    periode);

            byte[] data = glrService.getGLR912010101(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/9120102")
    public ResponseEntity<?> getGLR9120102(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "9120102");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("GC4DP0e",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR9120102", quser, title, subtitle, blth,
                    periode);
            byte[] data = glrService.getGLR9120102(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/912010201")
    public ResponseEntity<?> getGLR912010201(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "912010201");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("mcJPdgV",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR912010201", quser, title, subtitle, blth,
                    periode);
            byte[] data = glrService.getGLR912010201(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/912010301")
    public ResponseEntity<?> getGLR912010301(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "912010301");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("gyHkIUT",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR912010301", quser, title, subtitle, blth,
                    periode);
            byte[] data = glrService.getGLR912010301(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/912010401")
    public ResponseEntity<?> getGLR912010401(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "912010401");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("GbERME-",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR912010401", quser, title, subtitle, blth,
                    periode);
            byte[] data = glrService.getGLR912010401(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/912010501")
    public ResponseEntity<?> getGLR912010501(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "912010501");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("O2cxrah",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR912010501", quser, title, subtitle, blth,
                    periode);
            byte[] data = glrService.getGLR912010501(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/912010601")
    public ResponseEntity<?> getGLR912010601(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "912010601");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();

            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qsegmen", requestModel.getQsegmen());
            // params.put("p_segmen", requestModel.getP_segmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR912010601", quser, title, subtitle, blth,
                    periode);
            byte[] data = glrService.getGLR912010601(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    //febryan oprKeu
    @GetMapping("/9120109")
    public ResponseEntity<?> getGLR9120109(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "9120109");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("v3qxik2",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR9120109", quser, title, subtitle, blth, periode);
            byte[] data = glrService.getGLR9120109(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/9120108")
    public ResponseEntity<?> getGLR9120108(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "9120108");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("rQTkZ9C",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR9120108", quser, title, subtitle, blth, periode);
            byte[] data = glrService.getGLR9120108(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/9120107")
    public ResponseEntity<?> getGLR9120107(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "9120107");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("nv7crgO",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR9120107", quser, title, subtitle, blth, periode);
            byte[] data = glrService.getGLR9120107(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/9120106")
    public ResponseEntity<?> getGLR9120106(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "9120106");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("5DkiBiv",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR9120106", quser, title, subtitle, blth, periode);
            byte[] data = glrService.getGLR9120106(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/9120105")
    public ResponseEntity<?> getGLR9120105(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "9120105");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("sX7Og1R",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR9120105", quser, title, subtitle, blth, periode);
            byte[] data = glrService.getGLR9120105(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/9120104")
    public ResponseEntity<?> getGLR9120104(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "9120104");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("KlivAU_",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR9120104", quser, title, subtitle, blth, periode);
            byte[] data = glrService.getGLR9120104(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/9120101_02")
    public ResponseEntity<?> getGLR9120101_02(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "9120101_02");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("IOMOuxK",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR9120101_02", quser, title, subtitle, blth, periode);
            byte[] data = glrService.getGLR9120101_02(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/2023060002")
    public ResponseEntity<?> getGLR2023060002(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "2023060002");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qfungsi", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("uRqhajv",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR2023060002", quser, title, subtitle, blth, periode);
            byte[] data =  glrService.getGLR2023060002(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/2023060001")
    public ResponseEntity<?> getGLR2023060001(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "2023060001");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qfungsi", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("J7po6TJ",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR2023060001", quser, title, subtitle, blth, periode);
            byte[] data =  glrService.getGLR2023060001(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/20211001")
    public ResponseEntity<?> getGLR20211001(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "20211001");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("L1VTwel",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR20211001", quser, title, subtitle, blth, periode);
            byte[] data =  glrService.getGLR20211001(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }


    @GetMapping("/201908162")
    public ResponseEntity<?> getGLR201908162(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "201908162");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("GHZSZXj",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR201908162", quser, title, subtitle, blth, periode);
            byte[] data =  glrService.getGLR201908162(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/201908161")
    public ResponseEntity<?> getGLR201908161(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "201908161");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("h3Kedi8",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR201908161", quser, title, subtitle, blth, periode);
            byte[] data =  glrService.getGLR201908161(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/201908160")
    public ResponseEntity<?> getGLR201908160(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "201908160");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("G-vT6fi",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR201908160", quser, title, subtitle, blth, periode);
            byte[] data = glrService.getGLR201908160(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/201908159")
    public ResponseEntity<?> getGLR201908159(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "201908159");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("Y3qVnsA",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR201908159", quser, title, subtitle, blth, periode);
            byte[] data = glrService.getGLR201908159(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/201908156")
    public ResponseEntity<?> getGLR201908156(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "201908156");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("NMM3ffX",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR201908156", quser, title, subtitle, blth, periode);
            byte[] data = glrService.getGLR201908156(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/201908155")
    public ResponseEntity<?> getGLR201908155(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "201908155");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("GZ1JmOC",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR201908155", quser, title, subtitle, blth, periode);
            byte[] data = glrService.getGLR201908155(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/9120103")
    public ResponseEntity<?> getGLR9120103(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "9120103");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("FcmARL1",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR9120103", quser, title, subtitle, blth,
                    periode);
            byte[] data = glrService.getGLR9120103(paramList, additionalData);
            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/201908154")
    public ResponseEntity<?> getGLR201908154(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "201908154");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);
            Map<String, String> additionalData = utilityService.createAdditionalData("car1jji",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR201908154", quser, title, subtitle, blth, periode);
            byte[] data = glrService.getGLR201908154(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/201908153")
    public ResponseEntity<?> getGLR201908153(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "201908153");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("aKkwdjW",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR201908153", quser, title, subtitle, blth, periode);
            byte[] data = glrService.getGLR201908153(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/201908166")
    public ResponseEntity<?> getGLR201908166(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "201908166");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String title = requestModel.getP_segmen();
            String subtitle = requestModel.getP_kantor();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_kode_kantor", requestModel.getP_kantor());
            params.put("p_kode_segmen", requestModel.getP_segmen());
            params.put("p_periode", periode);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR201908166", p_user, title, subtitle, blth, periode);
            byte[] data = glrService.getGLR201908166(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/201908165")
    public ResponseEntity<?> getGLR201908165(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "201908165");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            String title = requestModel.getP_segmen();
            String subtitle = requestModel.getP_kantor();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_kode_kantor", requestModel.getP_kantor());
            params.put("p_kode_segmen", requestModel.getP_segmen());
            params.put("p_periode", periode);
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("FhE9vio",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR201908165", p_user, title, subtitle, blth, periode);
            byte[] data = glrService.getGLR201908165(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/201908152")
    public ResponseEntity<?> getGLR201908152(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "201908152");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("9UnEVCx",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR201908152", quser, title, subtitle, blth, periode);
            PostData data = glrService.getGLR201908152(paramList, additionalData);

            return new ResponseBuilder().success(data);

        }
    }

    @GetMapping("/201908151")
    public ResponseEntity<?> getGLR201908151(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "201908151");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("uo5eQcz",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR201908151", quser, title, subtitle, blth, periode);
            byte[] data = glrService.getGLR201908151(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/912010701")
    public ResponseEntity<?> getGLR912010701(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "912010701");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("etDMGpF",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR912010701", quser, title, subtitle, blth,
                    periode);
            byte[] data = glrService.getGLR912010701(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/912010801")
    public ResponseEntity<?> getGLR912010801(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "912010801");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("2A0vNep",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR912010801", quser, title, subtitle, blth,
                    periode);
            byte[] data = glrService.getGLR912010801(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/912010901")
    public ResponseEntity<?> getGLR912010901(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "912010901");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("9WHmpO1",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR912010901", quser, title, subtitle, blth,
                    periode);
            byte[] data = glrService.getGLR912010901(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/912020101")
    public ResponseEntity<?> getGLR912020101(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "912020101");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR912020101", quser, title, subtitle, blth,
                    periode);
            byte[] data = glrService.getGLR912020101(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/912020201")
    public ResponseEntity<?> getGLR912020201(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "912020201");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR912020201", quser, title, subtitle, blth,
                    periode);
            byte[] data = glrService.getGLR912020201(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/912020301")
    public ResponseEntity<?> getGLR912020301(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "912020301");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR912020301", quser, title, subtitle, blth,
                    periode);

            byte[] data = glrService.getGLR912020301(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/9320102")
    public ResponseEntity<?> getGLR9320102(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "9320102");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();

            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR9320102", quser, title, subtitle, blth,
                    periode);

            byte[] data = glrService.getGLR9320102(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/932010201")
    public ResponseEntity<?> getGLR932010201(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "932010201");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();

            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR932010201", quser, title, subtitle, blth,
                    periode);
            byte[] data = glrService.getGLR932010201(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/9320101")
    public ResponseEntity<?> getGLR9320101(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "9320101");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR9320101", quser, title, subtitle, blth,
                    periode);
            byte[] data = glrService.getGLR9320101(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/932010101")
    public ResponseEntity<?> getGLR932010101(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "932010101");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String title = requestModel.getQsegmen();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qtgl", periode);
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR932010101", quser, title, subtitle, blth,
                    periode);
            byte[] data = glrService.getGLR932010101(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    // febryan controlData
    @GetMapping("/202301")
    public ResponseEntity<?> getGLR202301(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "202301");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String subtitle = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qtgl", periode);
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qstatus", requestModel.getQstatus());
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR202301", quser, "LAPORAN MONITORING SALDO AKUN",
                    subtitle, blth, periode);
            byte[] data = glrService.getGLR202301(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/2023011")
    public ResponseEntity<?> getGLR2023011(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "2023011");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qtgl", periode);
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qstatus", requestModel.getQstatus());
            params.put("qakun", requestModel.getQakun());
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR2023011", quser,
                    "LAPORAN DETIL MONITORING SALDO AKUN", "KANTOR PUSAT", blth, periode);
            byte[] data = glrService.getGLR2023011(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/202302")
    public ResponseEntity<?> getGLR202302(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "202302");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qtgl", periode);
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qstatus", requestModel.getQstatus());
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR202302", quser, "LAPORAN MONITORING SALDO BANK",
                    "KANTOR PUSAT", blth, periode);
            byte[] data = glrService.getGLR202302(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/2023021")
    public ResponseEntity<?> getGLR2023021(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "2023021");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qtgl", periode);
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qstatus", requestModel.getQstatus());
            params.put("qakun", requestModel.getQakun());
            params.put("qkodebuku", requestModel.getQkodebuku());
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR2023021", quser,
                    "LAPORAN DETIL MONITORING SALDO BANK", "KANTOR PUSAT", blth, periode);
            byte[] data = glrService.getGLR2023021(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/202303")
    public ResponseEntity<?> getGLR202303(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "202303");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qtgl", periode);
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qstatus", requestModel.getQstatus());
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR202303", quser,
                    "LAPORAN MONITORING HUTANG PIUTANG IURAN", "KANTOR PUSAT", blth, periode);
            byte[] data = glrService.getGLR202303(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/2023031")
    public ResponseEntity<?> getGLR2023031(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "2023031");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qtgl", periode);
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qstatussaldo", requestModel.getQstatussaldo());
            params.put("qstatus", requestModel.getQstatus());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR2023031", quser, "PDS Program", "KANTOR PUSAT",
                    blth, periode);
            byte[] data = glrService.getGLR2023031(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/202304")
    public ResponseEntity<?> getGLR202304(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "202304");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qktr", requestModel.getQktr());
            params.put("qtgl", periode);
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qstatus", requestModel.getQstatus());
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR202304", quser,
                    "LAPORAN MONITORING HUTANG PIUTANG ANTAR PROGRAM", "KANTOR PUSAT", blth, periode);
            byte[] data = glrService.getGLR202304(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/2023041")
    public ResponseEntity<?> getGLR2023041(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "2023041");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String qtgl = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", qtgl);
            params.put("qktr", requestModel.getQktr());
            params.put("qtgl", qtgl);
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qstatussaldo", requestModel.getQstatussaldo());
            params.put("qstatus", requestModel.getQstatus());
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR2023041", quser, "PDS Program", "KANTOR PUSAT",
                    blth, qtgl);
            byte[] data = glrService.getGLR2023041(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/202305")
    public ResponseEntity<?> getGLR202305(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "202305");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String qtgl = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", qtgl);
            params.put("qktr", requestModel.getQktr());
            params.put("qtgl", qtgl);
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qstatus", requestModel.getQstatus());
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR202305", quser, "PDS Program", "KANTOR PUSAT",
                    blth, qtgl);
            byte[] data = glrService.getGLR202305(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/2023051")
    public ResponseEntity<?> getGLR2023051(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "2023051");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String qtgl = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", qtgl);
            params.put("qktr", requestModel.getQktr());
            params.put("qtgl", qtgl);
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qstatus", requestModel.getQstatus());
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR2023051", quser, "PDS Program", "KANTOR PUSAT",
                    blth, qtgl);
            byte[] data = glrService.getGLR2023051(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/202306")
    public ResponseEntity<?> getGLR202306(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "202306");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String qtgl = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", qtgl);
            params.put("qktr", requestModel.getQktr());
            params.put("qtgl", qtgl);
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qstatus", requestModel.getQstatus());
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR202306", quser, "PDS Program", "KANTOR PUSAT",
                    blth, qtgl);
            byte[] data = glrService.getGLR202306(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/2023061")
    public ResponseEntity<?> getGLR2023061(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "2023061");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String qtgl = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", qtgl);
            params.put("qktr", requestModel.getQktr());
            params.put("qtgl", qtgl);
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qstatussaldo", requestModel.getQstatussaldo());
            params.put("qstatus", requestModel.getQstatus());
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR2023061", quser, "PDS Program", "KANTOR PUSAT",
                    blth, qtgl);
            byte[] data = glrService.getGLR2023061(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/202307")
    public ResponseEntity<?> getGLR202307(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "202307");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String qtgl = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", qtgl);
            params.put("qtgl", qtgl);
            params.put("qstatuslapkeu", requestModel.getQstatuslapkeu());
            params.put("qprglapkeu", requestModel.getQprglapkeu());
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR202307", quser, "PDS Program", "KANTOR PUSAT",
                    blth, qtgl);
            byte[] data = glrService.getGLR202307(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/2023071")
    public ResponseEntity<?> getGLR2023071(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "2023071");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String qtgl = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", qtgl);
            params.put("qtgl", qtgl);
            params.put("qakun", requestModel.getQakun());
            params.put("qstatus", requestModel.getQstatus());
            params.put("quser", quser);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR2023071", quser, "PDS Program", "KANTOR PUSAT",
                    blth, qtgl);
            byte[] data = glrService.getGLR2023071(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/9120201")
    public ResponseEntity<?> getGLR9120201(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "9120201");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String qtgl = requestModel.getQtgl();
            String qktr = requestModel.getQktr();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", qtgl);
            params.put("qtgl", qtgl);
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qktr", qktr);
            params.put("quser", quser);
            paramList.add(params);


            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR9120201", quser, "PDS Program", qktr, blth, qtgl);
            byte[] data = glrService.getGLR9120201(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/9120202")
    public ResponseEntity<?> getGLR9120202(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "9120202");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String qktr = requestModel.getQktr();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qtgl", periode);
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qktr", qktr);
            params.put("quser", quser);
            paramList.add(params);


            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR9120202", quser, "PDS Program", qktr, blth, periode);
            byte[] data = glrService.getGLR9120202(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/9120203")
    public ResponseEntity<?> getGLR9120203(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "9120203");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String qtgl = requestModel.getQtgl();
            String qktr = requestModel.getQktr();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", qtgl);
            params.put("qtgl", qtgl);
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qkonsolidasi", requestModel.getQkonsolidasi());
            params.put("qktr", qktr);
            params.put("quser", quser);
            paramList.add(params);


            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR9120203", quser, "PDS Program", qktr, blth, qtgl);
            byte[] data = glrService.getGLR9120203(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/9320103")
    public ResponseEntity<?> getGLR9320103(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "9320103");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String qtgl = requestModel.getQtgl();
            String qktr = requestModel.getQktr();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", qtgl);
            params.put("qtgl", qtgl);
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qktr", qktr);
            params.put("quser", quser);
            paramList.add(params);


            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR9320103", quser, "PDS Program", qktr, blth, qtgl);
            byte[] data = glrService.getGLR9320103(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/9320106")
    public ResponseEntity<?> getGLR9320106(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "9320106");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String qtgl = requestModel.getQtgl();
            String qktr = requestModel.getQktr();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", qtgl);
            params.put("qtgl", qtgl);
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qktr", qktr);
            params.put("quser", quser);
            paramList.add(params);


            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR9320106", quser, "PDS Program", qktr, blth, qtgl);
            byte[] data = glrService.getGLR9320106(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/932010601")
    public ResponseEntity<?> getGLR932010601(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "932010601");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getQuser();
            String qtgl = requestModel.getQtgl();
            String qktr = requestModel.getQktr();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", qtgl);
            params.put("qtgl", qtgl);
            params.put("qsegmen", requestModel.getQsegmen());
            params.put("qktr", qktr);
            params.put("quser", quser);
            paramList.add(params);


            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR932010601", quser, "PDS Program", qktr, blth, qtgl);
            byte[] data = glrService.getGLR932010601(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/201908163")
    public ResponseEntity<?> getGLR201908163(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "201908163");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getP_user();
            String qtgl = requestModel.getP_periode();
            String qktr = requestModel.getP_kantor();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", qtgl);
            params.put("p_periode", qtgl);
            params.put("p_segmen", requestModel.getP_segmen());
            params.put("p_kantor", qktr);
            params.put("p_user", quser);
            paramList.add(params);


            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR201908163", quser, "#N/A", qktr, blth, qtgl);
            byte[] data = glrService.getGLR201908163(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

    @GetMapping("/201908164")
    public ResponseEntity<?> getGLR201908164(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        glrValidator.validate(requestModel, bindingResult, "201908164");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String quser = requestModel.getP_user();
            String qtgl = requestModel.getP_periode();
            String qktr = requestModel.getP_kantor();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", qtgl);
            params.put("p_periode", qtgl);
            params.put("p_segmen", requestModel.getP_segmen());
            params.put("p_kantor", qktr);
            params.put("p_user", quser);
            paramList.add(params);


            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "GLR201908164", quser, "#N/A", qktr, blth, qtgl);
            byte[] data = glrService.getGLR201908164(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }
    }

}
