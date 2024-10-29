package com.bpjstk.JSReport.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Component
public class ResponseError {
    private String code;
    private List<String> message;

    public ResponseError(String code, List<String> message) {
        this.code = code;
        this.message = message;
    }

    public ResponseError() {
        this.code = "";
        this.message = new ArrayList<>();
    }

}
