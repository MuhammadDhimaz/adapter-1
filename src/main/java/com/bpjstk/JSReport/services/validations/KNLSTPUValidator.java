package com.bpjstk.JSReport.services.validations;

import com.bpjstk.JSReport.models.RequestModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class KNLSTPUValidator implements Validator {
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
            case "022":
                validateKNLSTPU022(request, errors);
                break;
            case "023":
                validateKNLSTPU023(request, errors);
                break;
            case "027":
                validateKNLSTPU027(request, errors);
                break;
            case "028":
                validateKNLSTPU028(request, errors);
                break;
            case "029":
                validateKNLSTPU029(request, errors);
                break;
            case "030":
                validateKNLSTPU030(request, errors);
                break;
            case "031":
                validateKNLSTPU031(request, errors);
                break;

        }
    }

    private void validateKNLSTPU022(RequestModel request, Errors errors) {
        ParameterValidator.validateWilayah(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNLSTPU023(RequestModel request, Errors errors) {
        ParameterValidator.validateWilayah(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNLSTPU027(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNLSTPU028(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNLSTPU029(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNLSTPU030(RequestModel request, Errors errors) {
        ParameterValidator.validateWilayah(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNLSTPU031(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }


}
