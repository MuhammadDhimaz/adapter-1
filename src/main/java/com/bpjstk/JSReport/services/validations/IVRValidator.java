package com.bpjstk.JSReport.services.validations;

import com.bpjstk.JSReport.models.RequestModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class IVRValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return RequestModel.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RequestModel request = (RequestModel) target;
        validateIVR27010702(request, errors);
    }

    private void validateIVR27010702(RequestModel request, Errors errors) {
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }
}
