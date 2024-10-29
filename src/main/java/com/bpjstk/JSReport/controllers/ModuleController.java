package com.bpjstk.JSReport.controllers;

import com.bpjstk.JSReport.services.encryptions.DecryptionService;
import com.bpjstk.JSReport.services.utilities.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ModuleController {
    protected final DecryptionService decryptionService;
    protected final UtilityService utilityService;

    @Autowired
    public ModuleController(DecryptionService decryptionService, UtilityService utilityService) {
        this.decryptionService = decryptionService;
        this.utilityService = utilityService;
    }
}
