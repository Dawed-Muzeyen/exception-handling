package com.example.exception.thisistohandleexception.service;

import com.example.exception.thisistohandleexception.exception.StudentNotFoundException;
import com.example.exception.thisistohandleexception.model.Student;
import com.example.exception.thisistohandleexception.validator.StudentRegistrationValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Optional;

public class StudentService {
   static Logger logger = LoggerFactory.getLogger(StudentService.class);
    public static void main(String[] args) {
        Student student = new Student("dawed", "dawed@gmail.com",
                         "+251911678542", LocalDate.of(2000, 1, 1));



        StudentRegistrationValidator.ValidationResult result = StudentRegistrationValidator.isEmailValid()
                .and(StudentRegistrationValidator.isPhoneNumberValid())
                .and(StudentRegistrationValidator.isAnAdult())
                .apply(student);
    if(result != StudentRegistrationValidator.ValidationResult.SUCCESS) {
        throw new StudentNotFoundException(result.name());
    }
        logger.info(" \n Student Validation is Successful with the result " + result);
    }
}
