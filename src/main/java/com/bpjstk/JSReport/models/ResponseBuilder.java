package com.bpjstk.JSReport.models;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;


@Slf4j
public class ResponseBuilder {
    private final Response response = new Response();

    public ResponseEntity<byte[]> success(byte[] data, String format) {
        HttpHeaders headers = createHttpHeaders(format);
        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }

    public ResponseEntity<PostData> success(PostData data) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }


    private HttpHeaders createHttpHeaders(String format) {
        HttpHeaders headers = new HttpHeaders();
        if (format.equals("html-to-xlsx")) {
            headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
        } else {
            headers.setContentType(MediaType.APPLICATION_PDF);
        }
        return headers;
    }


    public ResponseEntity<Response> fail(Exception error) {
        String errorMessage = switch (error) {
            case DataAccessException ignored -> "Data Access Exception, " + error.getMessage();
            case InterruptedException ignored2 -> "Interrupted Exception, " + error.getMessage();
            case ExecutionException ignored3 -> "Execution Exception, " + error.getMessage();
            default -> "Unknown Exception : " + error.getMessage();
        };
        log.error(errorMessage);
        log.trace(Arrays.toString(error.getStackTrace()));
        List<String> messages = new ArrayList<>();
        messages.add("An unexpected error occurred:");
        messages.add(errorMessage);
        ResponseError responseError = new ResponseError("500 Internal Server Error", messages);
        response.setError(responseError);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<Response> fail(BindingResult bindingResult) {
        List<String> messages = new ArrayList<>();
        bindingResult.getAllErrors().forEach(
                it -> messages.add(Objects.requireNonNull(it.getCodes())[1])
        );
        ResponseError responseError = new ResponseError("400 Bad Request", messages);
        response.setError(responseError);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
