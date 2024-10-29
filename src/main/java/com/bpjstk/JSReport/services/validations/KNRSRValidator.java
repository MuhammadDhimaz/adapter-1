package com.bpjstk.JSReport.services.validations;

import com.bpjstk.JSReport.models.RequestModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class KNRSRValidator implements Validator {
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
            case "0021":
                validateKNRSR0021(request, errors);
                break;
            case "0022":
                validateKNRSR0022(request, errors);
                break;
            case "0023":
                validateKNRSR0023(request, errors);
                break;
            default:
                errors.reject("endpoint.unknown", "Unknown endpoint: " + endpoint);
                break;


        }
    }

    private void validateKNRSR0021(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode1(request, errors);
        ParameterValidator.validatePeriode2(request, errors);
        ParameterValidator.validatePerusahaan(request, errors);
        ParameterValidator.validateUser(request, errors);
    }
    private void validateKNRSR0022(RequestModel request, Errors errors) {
        ParameterValidator.validateTema(request, errors);
        ParameterValidator.validatePembina(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validatePeriode2(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNRSR0023(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePembina(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validatePeriode2(request, errors);
        ParameterValidator.validateUser(request, errors);
    }
}
