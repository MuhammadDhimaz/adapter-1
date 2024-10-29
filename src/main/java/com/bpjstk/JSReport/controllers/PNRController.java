package com.bpjstk.JSReport.controllers;

import com.bpjstk.JSReport.models.RequestModel;
import com.bpjstk.JSReport.models.ResponseBuilder;
import com.bpjstk.JSReport.services.encryptions.DecryptParamPropertyEditor;
import com.bpjstk.JSReport.services.encryptions.DecryptionService;
import com.bpjstk.JSReport.services.modules.PNRService;
import com.bpjstk.JSReport.services.utilities.UtilityService;
import com.bpjstk.JSReport.services.validations.PNRValidator;
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
@RequestMapping("/PNR")
public class PNRController extends ModuleController {
    private final PNRService pnrService;
    private final PNRValidator pnrValidator;

    @Autowired
    public PNRController(PNRService pnrService, PNRValidator pnrValidator, DecryptionService decryptionService, UtilityService utilityService) {
        super(decryptionService, utilityService);
        this.pnrService = pnrService;
        this.pnrValidator = pnrValidator;
    }


    @InitBinder("requestModel")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(pnrValidator);
        binder.registerCustomEditor(String.class, new DecryptParamPropertyEditor(decryptionService));
    }

    @GetMapping("/8601")
    public ResponseEntity<?> getPNR8601(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        pnrValidator.validate(requestModel, bindingResult, "8601");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String periode = requestModel.getP_periode();
            String periode2 = requestModel.getP_periode2();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            String p_user = requestModel.getP_user();
            params.put("p_periode", periode);
            params.put("p_periode2", periode2);
            params.put("p_kantor", requestModel.getP_kantor());
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "PNR8601",
                    p_user,
                    "Daftar Pemberi Kerja Tertinggi Kasus Klaim JKK Kantor Cabang",
                    periode2,
                    blth,
                    periode);
            byte[] data = pnrService.getPNR8601(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }

    @GetMapping("/8604")
    public ResponseEntity<?> getPNR8604(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        pnrValidator.validate(requestModel, bindingResult, "8604");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String periode = requestModel.getP_periode();
            String periode2 = requestModel.getP_periode2();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            String p_user = requestModel.getP_user();
            params.put("p_periode", periode);
            params.put("p_periode2", periode2);
            params.put("p_kantor", requestModel.getP_kantor());
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "PNR8604",
                    p_user,
                    "Daftar Pemberi Kerja Tidak Pernah Klaim JKK (Bukan Kecelakaan Lalu Lintas)",
                    periode2,
                    blth,
                    periode);
            byte[] data = pnrService.getPNR8604(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }

    @GetMapping("/8607")
    public ResponseEntity<?> getPNR8607(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        pnrValidator.validate(requestModel, bindingResult, "8607");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String periode = requestModel.getP_periode();
            String periode2 = requestModel.getP_periode2();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            String p_user = requestModel.getP_user();
            params.put("p_periode", periode);
            params.put("p_periode2", periode2);
            params.put("p_kantor", requestModel.getP_kantor());
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "PNR8607",
                    p_user,
                    "Daftar Pemberi Kerja Tertinggi Kasus JKK Lalu Lintas (Hanya JKK Lalu Lintas)",
                    periode2,
                    blth,
                    periode);
            byte[] data = pnrService.getPNR8607(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }

    @GetMapping("/8611")
    public ResponseEntity<?> getPNR8611(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        pnrValidator.validate(requestModel, bindingResult, "8611");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String periode = requestModel.getP_periode();
            String periode2 = requestModel.getP_periode2();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            String p_user = requestModel.getP_user();
            params.put("p_periode", periode);
            params.put("p_periode2", periode2);
            params.put("p_kantor", requestModel.getP_kantor());
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "PNR8611",
                    p_user,
                    "Daftar Pemberi Kerja Tidak Pernah Klaim JKK Lalu Lintas (JKK Lalu Lintas = 0)",
                    periode2,
                    blth,
                    periode);
            byte[] data = pnrService.getPNR8611(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }

    @GetMapping("/8621")
    public ResponseEntity<?> getPNR8621(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        pnrValidator.validate(requestModel, bindingResult, "8621");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String periode = requestModel.getP_periode();
            String periode2 = requestModel.getP_periode2();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            String p_user = requestModel.getP_user();
            params.put("p_periode", periode);
            params.put("p_periode2", periode2);
            params.put("p_kantor", requestModel.getP_kantor());
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "PNR8621",
                    p_user,
                    "DAFTAR PEMBERI KERJA TERTINGGI KASUS KLAIM JKK BERDASARKAN TANGGAL PEMBAYARAN (TIDAK TERMASUK KECELAKAAN LALU LINTAS)",
                    periode2,
                    blth,
                    periode);
            byte[] data = pnrService.getPNR8621(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }

    @GetMapping("/8624")
    public ResponseEntity<?> getPNR8624(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        pnrValidator.validate(requestModel, bindingResult, "8624");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String periode = requestModel.getP_periode();
            String periode2 = requestModel.getP_periode2();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            String p_user = requestModel.getP_user();
            params.put("p_periode", periode);
            params.put("p_periode2", periode2);
            params.put("p_kantor", requestModel.getP_kantor());
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "PNR8624",
                    p_user,
                    "DAFTAR PEMBERI KERJA TIDAK PERNAH MENGAJUKAN KASUS KLAIM JKK BERDASARKAN TANGGAL KLAIM (TIDAK TERMASUK KECELAKAAN LALU LINTAS, JKK = 0)",
                    periode2,
                    blth,
                    periode);
            byte[] data = pnrService.getPNR8624(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }

    @GetMapping("/8627")
    public ResponseEntity<?> getPNR8627(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        pnrValidator.validate(requestModel, bindingResult, "8627");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            String p_user = requestModel.getP_user();
            params.put("p_periode1", periode);
            params.put("p_periode2", requestModel.getP_periode2());
            params.put("p_kantor", requestModel.getP_kantor());
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "PNR8627",
                    p_user,
                    "DAFTAR PEMBERI KERJA TERTINGGI KASUS KLAIM JKK LALU LINTAS BERDASARKAN TANGGAL BAYAR",
                    "(HANYA KECELAKAAN LALU LINTAS)",
                    blth,
                    periode);
            byte[] data = pnrService.getPNR8627(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }

    @GetMapping("/8631")
    public ResponseEntity<?> getPNR8631(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        pnrValidator.validate(requestModel, bindingResult, "8631");
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {

            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String periode = requestModel.getP_periode();
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            String p_user = requestModel.getP_user();
            params.put("p_periode1", periode);
            params.put("p_periode2", requestModel.getP_periode2());
            params.put("p_kantor", requestModel.getP_kantor());
            params.put("p_user", p_user);
            paramList.add(params);

            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "PNR8631",
                    p_user,
                    "DAFTAR PEMBERI KERJA TIDAK PERNAH MENGAJUKAN KASUS KLAIM JKK LALU LINTAS BERDASARKAN TANGGAL KLAIM",
                    "(KASUS JKK LALU LINTAS = 0)",
                    blth,
                    periode);
            byte[] data = pnrService.getPNR8631(paramList, additionalData);

            return new ResponseBuilder().success(data, additionalData.get("recipe"));

        }

    }
}