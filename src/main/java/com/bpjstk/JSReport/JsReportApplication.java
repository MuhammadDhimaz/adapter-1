package com.bpjstk.JSReport;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAsync
public class JsReportApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsReportApplication.class, args);
    }

}
