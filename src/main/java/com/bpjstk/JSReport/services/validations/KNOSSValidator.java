package com.bpjstk.JSReport.services.validations;

import com.bpjstk.JSReport.models.RequestModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class KNOSSValidator implements Validator {

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
            case "3001":
                validateKNOSS(request, errors);
                break;
            case "005":
                validate005(request, errors);
                break;
            case "006":
                validate006(request, errors);
                break;
            case "007":
                validate007(request, errors);
                break;
            case "008":
                validate008(request, errors);
                break;
            default:
                errors.reject("endpoint.unknown", "Unknown endpoint: " + endpoint);
                break;


        }
    }

    private void validateKNOSS(RequestModel request, Errors errors) {
        ParameterValidator.validateKodeKantor(request, errors);
        ParameterValidator.validatePembina(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validate005(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePembina(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validate006(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validate007(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validate008(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }
}