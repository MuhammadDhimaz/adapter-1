package com.bpjstk.JSReport.services.validations;

import com.bpjstk.JSReport.models.RequestModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class JNRValidator implements Validator {

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
                validateJNR3001(request, errors);
                break;
            case "3002":
                validateJNR3002(request, errors);
                break;
            case "3003":
                validateJNR3003(request, errors);
                break;
            case "3004":
                validateJNR3004(request, errors);
                break;
            case "3005":
                validateJNR3005(request, errors);
                break;
            case "3006":
                validateJNR3006(request, errors);
                break;
            default:
                errors.reject("endpoint.unknown", "Unknown endpoint: " + endpoint);
                break;


        }
    }

    private void validateJNR3001(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePembina(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateJNR3002(RequestModel request, Errors errors) {
        ParameterValidator.validateUser(request, errors);
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
    }

    private void validateJNR3003(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validateNoProyek(request, errors);
        ParameterValidator.validatePeriode(request, errors);
    }

    private void validateJNR3004(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
    }

    private void validateJNR3005(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
    }

    private void validateJNR3006(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
    }

}
