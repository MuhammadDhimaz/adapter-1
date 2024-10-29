package com.bpjstk.JSReport.controllers;

import com.bpjstk.JSReport.services.modules.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@RestController
public class CommonController {
    private final CommonService commonService;

    @Autowired
    public CommonController(CommonService commonService) {
        this.commonService = commonService;
    }

    @GetMapping("/")
    public String printHelloWorld() {
        return "Welcome to JSReport Service for BPJSTK";
    }

    @GetMapping("/update")
    public String update(
            @RequestParam(name = "id") String id
    ) throws IOException, ExecutionException, InterruptedException {
        return commonService.updateData(id);
    }


}
