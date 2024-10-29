package com.bpjstk.JSReport.models.exceptions;


import com.bpjstk.JSReport.models.Response;
import com.bpjstk.JSReport.models.ResponseError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    private final Response response;
    private final ResponseError responseError;

    @Autowired
    public GlobalExceptionHandler(Response response, ResponseError responseError) {
        this.response = response;
        this.responseError = responseError;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> fail(Exception error) {
        String errorMessage = switch (error) {
            case DataAccessException ignored -> "Data Access Exception, " + error.getMessage();
            case InterruptedException ignored2 -> "Interrupted Exception, " + error.getMessage();
            case ExecutionException ignored3 -> "Execution Exception, " + error.getMessage();
            default -> "Unknown Exception : " + error.getMessage();
        };
        log.error(errorMessage);
        List<String> messages = new ArrayList<>();
        messages.add("An unexpected error occurred");
        messages.add(errorMessage);
        ResponseError responseError = new ResponseError("500 Internal Server Error", messages);
        response.setError(responseError);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Handle Validation Exception
    @ExceptionHandler(BindException.class)
    public ResponseEntity<Response> handleBindExceptionErrors(BindException ex, WebRequest request) {
        log.error("BindException, " + ex.getMessage());
        responseError.setCode("400 Bad Request");
        List<String> messages = new ArrayList<>();
        ex.getAllErrors().forEach(
                it -> messages.add(Objects.requireNonNull(it.getCodes())[1])
        );
        responseError.setMessage(messages);
        response.setError(responseError);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }
}
