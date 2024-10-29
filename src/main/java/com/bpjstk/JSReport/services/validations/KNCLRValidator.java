package com.bpjstk.JSReport.services.validations;

import com.bpjstk.JSReport.models.RequestModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class KNCLRValidator implements Validator {

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
            case "00001":
                KNCLR00001(request, errors);
                break;
            case "00003":
                KNCLR00003(request, errors);
                break;
            case "00005":
                KNCLR00005(request, errors);
                break;
            case "00008":
                KNCLR00008(request, errors);
                break;
            case "00009":
                KNCLR00009(request, errors);
                break;
            case "00011":
                KNCLR00011(request, errors);
                break;
        }
    }

    private void KNCLR00001(RequestModel request, Errors errors) {
        ParameterValidator.validateUser(request, errors);
//        ParameterValidator.validateKodeKantor(request,errors);
        ParameterValidator.validatePeriode(request, errors);
    }

    private void KNCLR00003(RequestModel request, Errors errors) {
        ParameterValidator.validateWilayah(request, errors);
        ParameterValidator.validateUser(request, errors);
        ParameterValidator.validatePeriode(request, errors);
    }

    private void KNCLR00005(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validateUser(request, errors);
        ParameterValidator.validatePeriode(request, errors);
    }

    private void KNCLR00008(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validateUser(request, errors);
        ParameterValidator.validatePembina(request, errors);
    }

    private void KNCLR00009(RequestModel request, Errors errors) {
        ParameterValidator.validateUser(request, errors);
        ParameterValidator.validatePembina(request, errors);
    }

    private void KNCLR00011(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validateUser(request, errors);
        ParameterValidator.validatePembina(request, errors);
    }


}
