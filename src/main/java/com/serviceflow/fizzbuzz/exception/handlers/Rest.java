package com.serviceflow.fizzbuzz.exception.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class Rest extends ResponseEntityExceptionHandler {
    // Add here exceptions to be handled

    @ExceptionHandler(NullPointerException.class)
    protected ResponseEntity<String> handleNullPointerException() {
        return new ResponseEntity<String>("NullPointerException", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(JsonProcessingException.class)
    protected ResponseEntity<String> handleJsonProcessingException() {
        return new ResponseEntity<String>("Could not process JSON", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
