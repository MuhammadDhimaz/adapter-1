package com.bpjstk.JSReport.services.validations;

import com.bpjstk.JSReport.models.RequestModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PNDValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return RequestModel.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RequestModel request = (RequestModel) target;
        validatePND901305(request, errors);
    }

    private void validatePND901305(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateSegmen(request, errors);
        ParameterValidator.validateUsia(request, errors);
        ParameterValidator.validateUsia2(request, errors);
        ParameterValidator.validateUser(request, errors);
    }
}
