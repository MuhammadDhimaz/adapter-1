package com.bpjstk.JSReport.services.validations;

import com.bpjstk.JSReport.models.RequestModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PNRValidator implements Validator {
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
            case "8601":
                validatePNR8601(request, errors);
                break;
            case "8604":
                validatePNR8604(request, errors);
                break;
            case "8607":
                validatePNR8607(request, errors);
                break;
            case "8611":
                validatePNR8611(request, errors);
                break;
            case "8621":
                validatePNR8621(request, errors);
                break;
            case "8624":
                validatePNR8624(request, errors);
                break;
            case "8627":
                validatePNR8627(request, errors);
                break;
            case "8631":
                validatePNR8631(request, errors);
                break;
            default:
                errors.reject("endpoint.unknown", "Unknown endpoint: " + endpoint);
                break;


        }
    }

    private void validatePNR8601(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validatePeriode2(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validatePNR8604(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validatePeriode2(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validatePNR8607(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validatePeriode2(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validatePNR8611(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validatePeriode2(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validatePNR8621(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validatePeriode2(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validatePNR8624(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validatePeriode2(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validatePNR8627(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validatePeriode2(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validatePNR8631(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validatePeriode2(request, errors);
        ParameterValidator.validateUser(request, errors);
    }
}
