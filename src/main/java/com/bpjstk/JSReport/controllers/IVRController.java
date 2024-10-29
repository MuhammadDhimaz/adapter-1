package com.bpjstk.JSReport.controllers;

import com.bpjstk.JSReport.models.RequestModel;
import com.bpjstk.JSReport.models.ResponseBuilder;
import com.bpjstk.JSReport.services.encryptions.DecryptParamPropertyEditor;
import com.bpjstk.JSReport.services.encryptions.DecryptionService;
import com.bpjstk.JSReport.services.modules.IVRService;
import com.bpjstk.JSReport.services.utilities.UtilityService;
import com.bpjstk.JSReport.services.validations.IVRValidator;
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
@RequestMapping("/IVR")
public class IVRController extends ModuleController {
    private final IVRService ivrService;
    private final IVRValidator ivrValidator;

    @Autowired
    public IVRController(IVRService ivrService, IVRValidator ivrValidator, DecryptionService decryptionService, UtilityService utilityService) {
        super(decryptionService, utilityService);
        this.ivrService = ivrService;
        this.ivrValidator = ivrValidator;
    }

    @InitBinder("requestModel")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(ivrValidator);
        binder.registerCustomEditor(String.class, new DecryptParamPropertyEditor(decryptionService));
    }

    @GetMapping("/27010702")
    public ResponseEntity<?> getIVR27010702(
            @ModelAttribute RequestModel requestModel,
            @RequestHeader(value = "Accept") String acceptHeader,
            BindingResult bindingResult
    ) throws Exception {
        ivrValidator.validate(requestModel, bindingResult);
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        } else {
            List<Map<String, String>> paramList = new ArrayList<>();
            Map<String, String> params = new HashMap<>();
            String p_user = requestModel.getQuser();
            String periode = requestModel.getQtgl();
            String blth = utilityService.getMonthYearFromDate("yyyyMMdd", periode);
            params.put("qtgl", periode);
            params.put("quser", p_user);
            paramList.add(params);
            Map<String, String> additionalData = utilityService.createAdditionalData("",
                    utilityService.getJsreportRecipe(acceptHeader), "IVR27010702", p_user, "Daftar Realisasi Iuran AR, ARK, ARtis & Petugas Pemeriksa", "", blth, periode);
            byte[] data = ivrService.getIVR27010702(paramList, additionalData);
            return new ResponseBuilder().success(data, additionalData.get("recipe"));
        }
    }


}
