package com.bpjstk.JSReport.services.encryptions;

import org.springframework.beans.factory.annotation.Autowired;

import java.beans.PropertyEditorSupport;

public class DecryptParamPropertyEditor extends PropertyEditorSupport {
    private final DecryptionService decryptionService;

    @Autowired
    public DecryptParamPropertyEditor(DecryptionService decryptionService) {
        this.decryptionService = decryptionService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
//            System.out.println(text);
            String decryptedValue = decryptionService.decrypt(text);
//            System.out.println(decryptedValue);
            setValue(decryptedValue);
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to decrypt value: " + text, e);
        }
    }
}
