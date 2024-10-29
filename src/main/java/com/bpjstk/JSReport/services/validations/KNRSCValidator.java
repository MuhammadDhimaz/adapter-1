package com.bpjstk.JSReport.services.validations;

import com.bpjstk.JSReport.models.RequestModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class KNRSCValidator implements Validator {

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
                KNRSC001(request, errors);
                break;
            case "021":
                KNRSC021(request, errors);
                break;
            case "024":
                KNRSC024(request, errors);
                break;
        }
    }

    private void KNRSC001(RequestModel request, Errors errors) {
        ParameterValidator.validateUser(request, errors);
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validatePembina(request, errors);
    }

    private void KNRSC021(RequestModel request, Errors errors) {
        ParameterValidator.validateUser(request, errors);
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
    }

    private void KNRSC024(RequestModel request, Errors errors) {
        ParameterValidator.validateUser(request, errors);
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
    }


}
