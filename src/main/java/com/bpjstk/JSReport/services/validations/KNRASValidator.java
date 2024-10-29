package com.bpjstk.JSReport.services.validations;

import com.bpjstk.JSReport.models.RequestModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class KNRASValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return RequestModel.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    }

    public void validate(Object target, Errors errors, String endpoint) {
        RequestModel request = (RequestModel) target;
        switch (endpoint) {
            case "001":
                validateKNRAS001(request, errors);
                break;
            case "002":
                validateKNRAS002(request, errors);
                break;
            case "003":
                validateKNRAS003(request, errors);
                break;

        }
    }

    private void validateKNRAS001(RequestModel request, Errors errors) {
        ParameterValidator.validateUser(request, errors);
        ParameterValidator.validateKomunitas(request, errors);
        ParameterValidator.validatePeriode(request, errors);
    }

    private void validateKNRAS002(RequestModel request, Errors errors) {
        ParameterValidator.validateUser(request, errors);
        ParameterValidator.validateKomunitas(request, errors);
        ParameterValidator.validatePeriode(request, errors);
    }

    private void validateKNRAS003(RequestModel request, Errors errors) {
        ParameterValidator.validateUser(request, errors);
        ParameterValidator.validateKomunitas(request, errors);
        ParameterValidator.validatePeriode(request, errors);
    }


}
