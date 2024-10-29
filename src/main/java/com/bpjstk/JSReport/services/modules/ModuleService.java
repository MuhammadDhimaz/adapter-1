package com.bpjstk.JSReport.services.modules;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class ModuleService {
    public DataService dataService;

    @Autowired
    public ModuleService(DataService dataService) {
        this.dataService = dataService;
    }
}
