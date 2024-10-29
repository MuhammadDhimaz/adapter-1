package com.bpjstk.JSReport.services.validations;

import com.bpjstk.JSReport.models.RequestModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class KNRValidator implements Validator {

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
            case "1043":
                validateKNR1043(request, errors);
                break;
            case "1050":
                validateKNR1050(request, errors);
                break;
            case "1051":
                validateKNR1051(request, errors);
                break;
            case "1052A":
                validateKNR1052A(request, errors);
                break;
            case "1052NA":
                validateKNR1052NA(request, errors);
                break;
            case "1111":
                validateKNR1111(request, errors);
                break;
            case "2203":
                validateKNR2203(request, errors);
                break;
            case "2204":
                validateKNR2204(request, errors);
                break;
            case "8801B":
                validateKNR8801B(request, errors);
                break;
            case "903056C":
                validateKNR903056C(request, errors);
                break;
            case "903057C":
                validateKNR903057C(request, errors);
                break;
            case "903057N":
                validateKNR903057N(request, errors);
                break;
            case "903057W":
                validateKNR903057W(request, errors);
                break;
            case "1411":
                validateKNR1411(request, errors);
                break;
            case "1412":
                validateKNR1412(request, errors);
                break;
            case "2202":
                validateKNR2202(request, errors);
                break;
            case "3329CSYR":
                validateKNR3329CSYR(request, errors);
                break;
            case "3329NSYR":
                validateKNR3329NSYR(request, errors);
                break;
            case "3329PSYR":
                validateKNR3329PSYR(request, errors);
                break;
            case "3329WSYR":
                validateKNR3329WSYR(request, errors);
                break;
            case "3428H":
                validateKNR3428H(request, errors);
                break;
            case "5402":
                validateKNR5402(request, errors);
                break;
            case "1022":
                validateKNR1022(request, errors);
                break;
            case "1023":
                validateKNR1023(request, errors);
                break;
            case "1024":
                validateKNR1024(request, errors);
                break;
            case "1025":
                validateKNR1025(request, errors);
                break;
            case "1040":
                validateKNR1040(request, errors);
                break;
            case "1041":
                validateKNR1041(request, errors);
                break;
            case "1042":
                validateKNR1042(request, errors);
                break;
            case "1402":
                validateKNR1402(request, errors);
                break;
            case "1410":
                validateKNR1410(request, errors);
                break;
            case "3440":
                validateKNR3440(request, errors);
                break;
            case "3444":
                validateKNR3444(request, errors);
                break;
            case "903056N":
                validateKNR903056N(request, errors);
                break;
            case "903056W":
                validateKNR903056W(request, errors);
                break;
            case "1021":
                validateKNR1021(request, errors);
                break;
            case "1003":
                validateKNR1003(request, errors);
                break;
            case "1004":
                validateKNR1004(request, errors);
                break;
            case "1006":
                validateKNR1006(request, errors);
                break;
            case "1007":
                validateKNR1007(request, errors);
                break;
            case "3438":
                validateKNR3438(request, errors);
                break;
            case "3506":
                validateKNR3506(request, errors);
                break;
            case "3507":
                validateKNR3507(request, errors);
                break;
            case "1001T":
                validateKNR1001T(request, errors);
                break;

            default:
                errors.reject("endpoint.unknown", "Unknown endpoint: " + endpoint);
                break;
        }
    }

    private void validateKNR1001T(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateKonsolidasi(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNR3444(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validatePeriode2(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNR1021(RequestModel request, Errors errors) {
        ParameterValidator.validateRole(request, errors);
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNR903056W(RequestModel request, Errors errors) {
        ParameterValidator.validateWilayah(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNR903056N(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNR3440(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNR1410(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNR1402(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validateKonsolidasi(request, errors);
        ParameterValidator.validateUser(request, errors);
        ParameterValidator.validatePeriode(request, errors);
    }

    private void validateKNR1043(RequestModel request, Errors errors) {
        ParameterValidator.validateUser(request, errors);
        ParameterValidator.validatePeriode(request, errors);
    }

    private void validateKNR1050(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateProvinsi(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNR1051(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateKabupaten(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNR1052A(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNR1052NA(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNR1111(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNR2203(RequestModel request, Errors errors) {
        ParameterValidator.validateWilayah(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNR2204(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNR8801B(RequestModel request, Errors errors) {
        ParameterValidator.validateKodeKantor(request, errors);
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePembina(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateRole(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNR903056C(RequestModel request, Errors errors) {
        ParameterValidator.validateUser(request, errors);
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);

    }

    private void validateKNR903057C(RequestModel request, Errors errors) {
        ParameterValidator.validateUser(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateKantor(request, errors);
    }

    private void validateKNR903057N(RequestModel request, Errors errors) {
        ParameterValidator.validateUser(request, errors);
        ParameterValidator.validatePeriode(request, errors);
    }

    private void validateKNR903057W(RequestModel request, Errors errors) {
        ParameterValidator.validateUser(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateWilayah(request, errors);
    }

    private void validateKNR1411(RequestModel request, Errors errors) {
        ParameterValidator.validateWilayah(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNR1412(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNR2202(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validateKonsolidasi(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNR3329CSYR(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validateSegmen(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNR3329NSYR(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateSegmen(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNR3329PSYR(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateSegmen(request, errors);
        ParameterValidator.validatePembina(request, errors);
        ParameterValidator.validateUser(request, errors);
        ParameterValidator.validateKantor(request, errors);

    }

    private void validateKNR3329WSYR(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateSegmen(request, errors);
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNR3428H(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateNpp(request, errors);
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validateDivisi(request, errors);
        ParameterValidator.validateUser(request, errors);
    }


    private void validateKNR5402(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validateSegmen(request, errors);
        ParameterValidator.validateNpp(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
        ParameterValidator.validatePembina(request, errors);
    }

    private void validateKNR1022(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNR1023(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
        ParameterValidator.validateWilayah(request, errors);
    }


    private void validateKNR1024(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNR1025(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
        ParameterValidator.validateKonsolidasi(request, errors);
        ParameterValidator.validateRole(request, errors);
        ParameterValidator.validateKantor(request, errors);
    }

    private void validateKNR1040(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
        ParameterValidator.validatePembina(request, errors);
        ParameterValidator.validateBadanHukum(request, errors);
        ParameterValidator.validateKantor(request, errors);
    }

    private void validateKNR1041(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
        ParameterValidator.validateKantor(request, errors);
    }

    private void validateKNR1042(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateUser(request, errors);
        ParameterValidator.validateWilayah(request, errors);
    }

    private void validateKNR1003(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validatePeriode2(request, errors);
        ParameterValidator.validateUser(request, errors);
        ParameterValidator.validateKantor(request, errors);
    }

    private void validateKNR1004(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validatePeriode2(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNR1006(RequestModel request, Errors errors) {
        ParameterValidator.validateWilayah(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNR1007(RequestModel request, Errors errors) {
        ParameterValidator.validateUser(request, errors);
    }

    private void validateKNR3506(RequestModel request, Errors errors) {
        ParameterValidator.validateUser(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validatePeriode2(request, errors);
        ParameterValidator.validateSegmen(request, errors);
        ParameterValidator.validateNpp(request, errors);
        ParameterValidator.validateSaldo(request, errors);
        ParameterValidator.validateSaldo2(request, errors);
        ParameterValidator.validateKonsolidasi(request, errors);
        ParameterValidator.validateKantor(request, errors);
    }

    private void validateKNR3507(RequestModel request, Errors errors) {
        ParameterValidator.validateUser(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validatePeriode2(request, errors);
        ParameterValidator.validateSegmen(request, errors);
        ParameterValidator.validateNpp(request, errors);
        ParameterValidator.validateSaldo(request, errors);
        ParameterValidator.validateSaldo2(request, errors);
        ParameterValidator.validateKonsolidasi(request, errors);
        ParameterValidator.validateKantor(request, errors);
    }

    private void validateKNR3438(RequestModel request, Errors errors) {
        ParameterValidator.validateUser(request, errors);
    }


}
