package com.example.exception.thisistohandleexception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException{
   private String message;

   public StudentNotFoundException(String message) {
       super(message);
    }
}
