package com.bpjstk.JSReport.configurations;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Base64;

@Configuration
public class WebClientConfiguration {

    @Value("${app.datasource.jsreport.base-url}")
    private String baseUrl;
    @Value("${app.datasource.jsreport.username}")
    private String username;
    @Value("${app.datasource.jsreport.password}")
    private String password;

    @Bean
    public WebClient build() {
        // change this memory size to fix memory limit WebClient limit memory buffer bug
        final int size = 512 * 1024 * 1024;
        final String cred = createAuth();
        final ExchangeStrategies strategies = ExchangeStrategies.builder()
                .codecs(codecs -> codecs
                        .defaultCodecs()
                        .maxInMemorySize(size))
                .build();
        return WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("Authorization", "Basic " + cred)
                .exchangeStrategies(strategies)
                .build();
    }

    private String createAuth() {
        String token = username + ":" + password;
        return Base64.getEncoder().encodeToString(token.getBytes());
    }
}
