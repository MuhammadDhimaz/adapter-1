package com.bpjstk.JSReport.services.validations;

import com.bpjstk.JSReport.models.RequestModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class KSARValidator implements Validator {
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
            case "107":
                validateKSAR107(request, errors);
                break;
            case "108":
                validateKSAR108(request, errors);
                break;
            case "109":
                validateKSAR109(request, errors);
                break;

        }
    }

    private void validateKSAR107(RequestModel request, Errors errors) {
        ParameterValidator.validateUser(request, errors);
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
    }

    private void validateKSAR108(RequestModel request, Errors errors) {
        ParameterValidator.validateUser(request, errors);
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
    }

    private void validateKSAR109(RequestModel request, Errors errors) {
        ParameterValidator.validateUser(request, errors);
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
    }


}
