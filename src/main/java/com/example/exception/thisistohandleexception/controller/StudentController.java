package com.example.exception.thisistohandleexception.controller;

import com.example.exception.thisistohandleexception.exception.StudentIllegalFoundException;
import com.example.exception.thisistohandleexception.exception.StudentNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

@RequestMapping(path = "/api/v1/students")
    public String getStudents() {
    int a = 9;

    if(a == 9)
        throw new StudentNotFoundException("good student");

    return "hello";
}
    @RequestMapping(path = "/api/v1/students2")
    public String getStudent2() {
        int a = 9;

        if(a == 9)
            throw new StudentIllegalFoundException("Illegal student");

        return "hello";
    }

    @RequestMapping(path = "/api/v1/student")
    public String getStudent() throws Exception {
        int a = 9;

        if(a == 9)
            throw new Exception("Beyond my scope!");

        return "hello";
    }
}
