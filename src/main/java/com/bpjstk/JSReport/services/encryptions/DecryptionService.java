package com.bpjstk.JSReport.services.encryptions;

import com.bpjstk.JSReport.configurations.DecryptionConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class DecryptionService {

    private final DecryptionConfiguration decryptionConfiguration;

    @Autowired
    public DecryptionService(DecryptionConfiguration decryptionConfiguration) {
        this.decryptionConfiguration = decryptionConfiguration;
    }

    public String decrypt(String encryptedValue) throws Exception {
        String[] parts = encryptedValue.split(":");
        String encodedIV = parts[0];
        String encodedEncryptedData = parts[1];

        byte[] iv = Base64.getDecoder().decode(encodedIV);
        byte[] encryptedData = Base64.getDecoder().decode(encodedEncryptedData);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, decryptionConfiguration.getSecretKey(), new IvParameterSpec(iv));

        byte[] decryptedBytes = cipher.doFinal(encryptedData);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }
}
