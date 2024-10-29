package com.bpjstk.JSReport.services.validations;

import com.bpjstk.JSReport.models.RequestModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class GLRValidator implements Validator {
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
            case "201908157":
                validateGLR201908157(request, errors);
                break;
            case "201908158":
                validateGLR201908158(request, errors);
                break;
            case "9120101":
                validateGLR9120101(request, errors);
                break;
            case "912010101":
                validateGLR912010101(request, errors);
                break;
            case "9120102":
                validateGLR9120102(request, errors);
                break;
            case "912010201":
                validateGLR912010201(request, errors);
                break;
            case "912010301":
                validateGLR912010301(request, errors);
                break;
            case "912010401":
                validateGLR912010401(request, errors);
                break;
            case "912010501":
                validateGLR912010501(request, errors);
                break;
            case "912010601":
                validateGLR912010601(request, errors);
                break;
            case "912010701":
                validateGLR912010701(request, errors);
                break;
            case "912010801":
                validateGLR912010801(request, errors);
                break;
            case "912010901":
                validateGLR912010901(request, errors);
                break;
            case "912020101":
                validateGLR912020101(request, errors);
                break;
            case "912020201":
                validateGLR912020201(request, errors);
                break;
            case "912020301":
                validateGLR912020301(request, errors);
                break;
            case "9320102":
                validateGLR9320102(request, errors);
                break;
            case "932010201":
                validateGLR932010201(request, errors);
                break;
            case "9320101":
                validateGLR9320101(request, errors);
                break;
            case "932010101":
                validateGLR932010101(request, errors);
                break;
            case "202301":
                validateGLR202301(request, errors);
                break;
            case "2023011":
                validateGLR2023011(request, errors);
                break;
            case "202302":
                validateGLR202302(request, errors);
                break;
            case "2023021":
                validateGLR2023021(request, errors);
                break;
            case "202303":
                validateGLR202303(request, errors);
                break;
            case "2023031":
                validateGLR2023031(request, errors);
                break;
            case "202304":
                validateGLR202304(request, errors);
                break;
            case "2023041":
                validateGLR2023041(request, errors);
                break;
            case "202305":
                validateGLR202305(request, errors);
                break;
            case "2023051":
                validateGLR2023051(request, errors);
                break;
            case "202306":
                validateGLR202306(request, errors);
                break;
            case "2023061":
                validateGLR2023061(request, errors);
                break;
            case "202307":
                validateGLR202307(request, errors);
                break;
            case "2023071":
                validateGLR2023071(request, errors);
                break;
            case "201908151":
                validateGLR201908151(request, errors);
                break;
            case "201908152":
                validateGLR201908152(request, errors);
                break;
            case "201908165":
                validateGLR201908165(request, errors);
                break;
            case "201908166":
                validateGLR201908166(request, errors);
                break;
            case "201908153":
                validateGLR201908153(request, errors);
                break;
            case "201908154":
                validateGLR201908154(request, errors);
                break;
            case "9120103":
                validateGLR9120103(request, errors);
                break;
            case "201908155":
                validateGLR201908155(request, errors);
                break;
            case "201908156":
                validateGLR201908156(request, errors);
                break;
            case "201908159":
                validateGLR201908159(request, errors);
                break;
            case "201908160":
                validateGLR201908160(request, errors);
                break;
            case "9120201":
                validateGLR9120201(request, errors);
                break;
            case "9120202":
                validateGLR9120202(request, errors);
                break;
            case "9120203":
                validateGLR9120203(request, errors);
                break;
            case "9320103":
                validateGLR9320103(request, errors);
                break;
            case "9320106":
                validateGLR9320106(request, errors);
                break;
            case "932010601":
                validateGLR932010601(request, errors);
                break;
            case "201908161":
                validateGLR201908161(request, errors);
                break;
            case "9120104":
                validateGLR9120104(request, errors);
                break;
            case "9120105":
                validateGLR9120105(request, errors);
                break;
            case "9120106":
                validateGLR9120106(request, errors);
                break;
            case "9120107":
                validateGLR9120107(request, errors);
                break;
            case "9120108":
                validateGLR9120108(request, errors);
                break;
            case "9120109":
                validateGLR9120109(request, errors);
                break;
            case "201908162":
                validateGLR201908162(request, errors);
                break;

            case "201908163":
                validateGLR201908163(request, errors);
                break;
            case "201908164":
                validateGLR201908164(request, errors);
                break;
            case "20211001":
                validateGLR20211001(request, errors);
                break;
            case "2023060001":
                validateGLR2023060001(request, errors);
                break;
            case "2023060002":
                validateGLR2023060002(request, errors);
                break;
            case "9120101_02":
                validateGLR9120101_02(request, errors);
                break;
            default:
                errors.reject("endpoint.unknown", "Unknown endpoint: " + endpoint);
                break;
        }
    }
    //GLR OPRKEU
    private void validateGLR9120101_02(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR2023060002(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQfungsi(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR2023060001(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQfungsi(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }


    private void validateGLR20211001(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR201908162(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR9120109(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR9120108(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR9120107(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR9120106(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR9120105(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR9120104(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR201908161(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR201908160(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR201908159(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR201908156(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR201908155(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR9120103(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR201908154(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR201908153(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR201908166(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateSegmen(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateGLR201908165(RequestModel request, Errors errors) {
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateSegmen(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateGLR201908152(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR201908151(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR201908157(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR201908158(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR9120101(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
    }

    private void validateGLR912010101(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
    }

    private void validateGLR9120102(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR912010201(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR912010301(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR912010401(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR912010501(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR912010601(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
    }


    //febryan
    private void validateGLR912010701(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR912010801(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR912010901(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR912020101(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR912020201(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR912020301(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR9320102(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR932010201(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR9320101(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR932010101(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }


    //febryan controlData
    private void validateGLR202301(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
        ParameterValidator.validateQstatus(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR2023011(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
        ParameterValidator.validateQstatus(request, errors);
        ParameterValidator.validateQakun(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR202302(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
        ParameterValidator.validateQstatus(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR2023021(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
        ParameterValidator.validateQstatus(request, errors);
        ParameterValidator.validateQakun(request, errors);
        ParameterValidator.validateQkodebuku(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR202303(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
        ParameterValidator.validateQstatus(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR2023031(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
        ParameterValidator.validateQstatussaldo(request, errors);
        ParameterValidator.validateQstatus(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR202304(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
        ParameterValidator.validateQstatus(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR2023041(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
        ParameterValidator.validateQstatussaldo(request, errors);
        ParameterValidator.validateQstatus(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR202305(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
        ParameterValidator.validateQstatus(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR2023051(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
        ParameterValidator.validateQstatus(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR202306(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
        ParameterValidator.validateQstatus(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR2023061(RequestModel request, Errors errors) {
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
        ParameterValidator.validateQstatussaldo(request, errors);
        ParameterValidator.validateQstatus(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR202307(RequestModel request, Errors errors) {
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQstatusLapkeu(request, errors);
        ParameterValidator.validateQprgLapkeu(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR2023071(RequestModel request, Errors errors) {
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQakun(request, errors);
        ParameterValidator.validateQstatus(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR9120201(RequestModel request, Errors errors) {
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR9120202(RequestModel request, Errors errors) {
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR9120203(RequestModel request, Errors errors) {
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQkonsolidasi(request, errors);
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR9320103(RequestModel request, Errors errors) {
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR9320106(RequestModel request, Errors errors) {
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR932010601(RequestModel request, Errors errors) {
        ParameterValidator.validateQtgl(request, errors);
        ParameterValidator.validateQsegmen(request, errors);
        ParameterValidator.validateQktr(request, errors);
        ParameterValidator.validateQuser(request, errors);
    }

    private void validateGLR201908163(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateSegmen(request, errors);
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validateUser(request, errors);
    }

    private void validateGLR201908164(RequestModel request, Errors errors) {
        ParameterValidator.validatePeriode(request, errors);
        ParameterValidator.validateSegmen(request, errors);
        ParameterValidator.validateKantor(request, errors);
        ParameterValidator.validateUser(request, errors);
    }


}
