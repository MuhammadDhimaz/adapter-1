package com.bpjstk.JSReport.services.validations;

import com.bpjstk.JSReport.models.RequestModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MISRValidator implements Validator {
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
            case "1001":
                validateMISR1001(request, errors);
                break;
            case "1002":
                validateMISR1002(request, errors);
                break;
            case "1003":
                validateMISR1003(request, errors);
                break;
            case "1004":
                validateMISR1004(request, errors);
                break;
            case "1005":
                validateMISR1005(request, errors);
                break;
            case "1006":
                validateMISR1006(request, errors);
                break;
            case "1007":
                validateMISR1007(request, errors);
                break;
            case "1008":
                validateMISR1008(request, errors);
                break;
            case "1010":
                validateMISR1010(request, errors);
                break;
            case "1011":
                validateMISR1011(request, errors);
                break;
            case "1012":
                validateMISR1012(request, errors);
                break;
        }
    }
    private void validateMISR1010(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateSegmen(request, errors);
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validateUser(request, errors);
    }
    private void validateMISR1008(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateSegmen(request, errors);
        ParameterValidator.validateProgram(request, errors);
        ParameterValidator.validateUser(request, errors);
    }
    private void validateMISR1007(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateSegmen(request, errors);
        ParameterValidator.validateProgram(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateMISR1001(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateMISR1002(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateMISR1003(RequestModel request, Errors errors) {
//        ParameterValidator.validateKantor();(request,errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateMISR1004(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateMISR1005(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateSegmen(request, errors);
        ParameterValidator.validateProgram(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateMISR1006(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateSegmen(request, errors);
        ParameterValidator.validateProgram(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateMISR1011(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateSegmen(request, errors);
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateMISR1012(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateSegmen(request, errors);
        ParameterValidator.validateUser(request, errors);
    }


}
