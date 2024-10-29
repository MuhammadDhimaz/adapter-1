package com.bpjstk.JSReport.configurations;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;


@Configuration
public class DecryptionConfiguration {

    @Value("${app.security.secret-key}")
    private String encryptedSecretKey;

    @Getter
    private SecretKeySpec secretKey;

    @PostConstruct
    public void init() {
        byte[] keyBytes = Base64.getDecoder().decode(encryptedSecretKey);
        this.secretKey = new SecretKeySpec(keyBytes, "AES");
    }
}
