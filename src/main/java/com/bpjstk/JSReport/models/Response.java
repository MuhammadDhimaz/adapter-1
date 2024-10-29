package com.bpjstk.JSReport.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class Response {
    private String status;
    private String result;
    private ResponseError error;
    private byte[] data;
}
