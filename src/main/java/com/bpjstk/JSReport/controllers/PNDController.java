package com.bpjstk.JSReport.controllers;

import com.bpjstk.JSReport.models.RequestModel;
import com.bpjstk.JSReport.models.ResponseBuilder;
import com.bpjstk.JSReport.services.encryptions.DecryptParamPropertyEditor;
import com.bpjstk.JSReport.services.encryptions.DecryptionService;
import com.bpjstk.JSReport.services.modules.PNDService;
import com.bpjstk.JSReport.services.utilities.UtilityService;
import com.bpjstk.JSReport.services.validations.PNDValidator;
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
@RequestMapping("/PND")
public class PNDController extends ModuleController {
    private final PNDService pndService;
    private final PNDValidator pndValidator;

    @Autowired
    public PNDController(PNDService pndService, PNDValidator pndValidator, DecryptionService decryptionService, UtilityService utilityService) {
        super(decryptionService, utilityService);
        this.pndService = pndService;
        this.pndValidator = pndValidator;
    }

    @InitBinder("requestModel")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(pndValidator);
        binder.registerCustomEditor(String.class, new DecryptParamPropertyEditor(decryptionService));
    }

    @GetMapping("/901305")
    public ResponseEntity<?> getPND901305(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        pndValidator.validate(requestModel, bindingResult);
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getP_user();
            LocalDateTime now = LocalDateTime.now();
            String periode = now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            String blth = utilityService.getMonthYearFromDate("dd-MM-yyyy", periode);
            params.put("p_kantor", requestModel.getP_kantor());
            params.put("p_periode", periode);
            params.put("p_segmen", requestModel.getP_segmen());
            params.put("p_usia", requestModel.getP_usia());
            params.put("p_usia2", requestModel.getP_usia2());
            params.put("p_user", p_user);
            paramList.add(params);
            Map<String, String> additionalData = utilityService.createAdditionalData(
                    "",
                    utilityService.getJsreportRecipe(acceptHeader),
                    "PND901305",
                    p_user,
                    "Daftar Realisasi Iuran AR, ARK, ARtis & Petugas Pemeriksa",
                    "",
                    blth,
                    periode);
            byte[] data = pndService.getPND901305(paramList, additionalData);
            return new ResponseBuilder().success(data, additionalData.get("recipe"));
        }
    }


}
