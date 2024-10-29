package com.bpjstk.JSReport.services.validations;

import com.bpjstk.JSReport.models.RequestModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class KNRBPUValidator implements Validator {

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
            case "0014":
                validateKNRBPU0014(request, errors);
                break;
            case "0015":
                validateKNRBPU0015(request, errors);
                break;
            case "0038":
                validateKNRBPU0038(request, errors);
                break;
            case "0039":
                validateKNRBPU0039(request, errors);
                break;
            default:
                errors.reject("endpoint.unknown", "Unknown endpoint: " + endpoint);
                break;


        }
    }

    private void validateKNRBPU0039(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNRBPU0038(RequestModel request, Errors errors) {
        ParameterValidator.validateChannel(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNRBPU0015(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNRBPU0014(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validateUser(request, errors);
    }
}
