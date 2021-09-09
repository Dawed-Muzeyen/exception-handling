package com.example.exception.thisistohandleexception.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
//@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = StudentNotFoundException.class)
    ResponseEntity<Object> handleApiException(StudentNotFoundException ex, WebRequest request) {
        ResponsePayload responsePayload = new ResponsePayload(ZonedDateTime.now(ZoneId.of("Z")), ex.getMessage(), HttpStatus.NOT_FOUND);

        return new ResponseEntity<Object>(responsePayload, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = StudentIllegalFoundException.class)
    ResponseEntity<Object> handleApiException(StudentIllegalFoundException ex, WebRequest request) {
        ResponsePayload responsePayload = new ResponsePayload(ZonedDateTime.now(ZoneId.of("Z")), ex.getMessage(), HttpStatus.EXPECTATION_FAILED);

        return new ResponseEntity<Object>(responsePayload, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(value = Exception.class)
    ResponseEntity<Object> handleApiException(Exception ex, WebRequest request) {
        ResponsePayload responsePayload = new ResponsePayload(ZonedDateTime.now(ZoneId.of("Z")), ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<Object>(responsePayload, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
