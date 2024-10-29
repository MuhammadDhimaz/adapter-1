package com.bpjstk.JSReport.services.validations;

import com.bpjstk.JSReport.models.RequestModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class KNNAValidator implements Validator {

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
            case "1006":
                validateKNNA1006(request, errors);
                break;
            case "1007":
                validateKNNA1007(request, errors);
                break;
            case "1008":
                validateKNNA1008(request, errors);
                break;
            case "1009":
                validateKNNA1009(request, errors);
                break;
            case "1010":
                validateKNNA1010(request, errors);
                break;
            case "1011":
                validateKNNA1011(request, errors);
                break;
            case "1003":
                validateKNNA1003(request, errors);
                break;
            case "1004":
                validateKNNA1004(request, errors);
                break;
            case "1005":
                validateKNNA1005(request, errors);
                break;
            default:
                errors.reject("endpoint.unknown", "Unknown endpoint: " + endpoint);
                break;


        }
    }

    private void validateKNNA1006(RequestModel request, Errors errors) {
        ParameterValidator.validateKabupaten(request, errors);
        ParameterValidator.validateProvinsi(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNNA1007(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePembina(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNNA1008(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNNA1009(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNNA1010(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNNA1011(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
        ParameterValidator.validateProvinsi(request, errors);
        ParameterValidator.validateKabupaten(request, errors);
        ParameterValidator.validateKementrian(request, errors);
    }

    private void validateKNNA1003(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNNA1004(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNNA1005(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
        ParameterValidator.validateProvinsi(request, errors);
        ParameterValidator.validateKabupaten(request, errors);
    }
}