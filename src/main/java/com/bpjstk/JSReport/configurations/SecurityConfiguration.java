package com.bpjstk.JSReport.configurations;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfiguration {

    @Value("${app.security.authLoginConfig}")
    private String authLoginConfig;

    @Value("${app.security.krb5Config}")
    private String krb5Config;

    @PostConstruct
    public void init() {
        System.setProperty("java.security.auth.login.config", authLoginConfig);
        System.setProperty("java.security.krb5.conf", krb5Config);
    }
}