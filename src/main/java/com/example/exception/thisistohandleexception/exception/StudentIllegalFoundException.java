package com.example.exception.thisistohandleexception.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public class StudentIllegalFoundException extends RuntimeException {

    private  String message;

    public StudentIllegalFoundException(String message) {
        super(message);

    }
}
