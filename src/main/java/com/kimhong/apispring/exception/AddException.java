package com.kimhong.apispring.exception;

import com.kimhong.apispring.rest.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class AddException {

    @ExceptionHandler(value = ResponseStatusException.class)
    ResponseEntity<ErrorResponse> handle(ResponseStatusException e){

        ErrorResponse response = new ErrorResponse();
        response.setMessage("The operation fialed. Please check error");
        response.setCode(e.getStatus().value());
        response.setError(e.getMessage());
        return ResponseEntity.ok(response);

    }
}
