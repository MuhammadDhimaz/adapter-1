package com.bpjstk.JSReport.models;

public class ValidationMessages {
    //GENERAL VALDIATION
    public static final String FIELD_REQUIRED = "{validation.field.required}";
    //P_KANTOR VALIDATION
    public static final String P_KANTOR_LENGTH = "p_kantor must have length exactly 3";

    //P_PERIODE VALIDATION
    public static final String P_PERIODE_FORMAT = "should be in the format DD-MM-YYYY";
    public static final String P_PERIODE_LENGTH = "must have length exactly 10";

    //QTGL VALIDATION
    public static final String QTGL_FORMAT = "should be in the format YYYYMMDD";
    public static final String QTGL_LENGTH = "must have length exactly 8";

    //P_SEGMEN VALIDATION
    public static final String P_SEGMENT_LENGTH = "must have length exactly 1";
}
