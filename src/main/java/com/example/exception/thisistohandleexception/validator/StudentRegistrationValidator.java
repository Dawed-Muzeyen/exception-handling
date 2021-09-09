package com.example.exception.thisistohandleexception.validator;

import com.example.exception.thisistohandleexception.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static com.example.exception.thisistohandleexception.validator.StudentRegistrationValidator.ValidationResult.SUCCESS;
import static com.example.exception.thisistohandleexception.validator.StudentRegistrationValidator.ValidationResult.EMAIL_NOT_VALID;
import static com.example.exception.thisistohandleexception.validator.StudentRegistrationValidator.ValidationResult.PHONE_NUMBER_NOT_VALID;
import static com.example.exception.thisistohandleexception.validator.StudentRegistrationValidator.ValidationResult.IS_NOT_AN_ADULT;

public interface StudentRegistrationValidator  extends Function<Student, StudentRegistrationValidator.ValidationResult > {
     enum ValidationResult {
          SUCCESS,
        EMAIL_NOT_VALID,
        PHONE_NUMBER_NOT_VALID,
        IS_NOT_AN_ADULT
    };

    Logger logger = LoggerFactory.getLogger(StudentRegistrationValidator.class);

    static StudentRegistrationValidator isEmailValid() {
        logger.info("Running Email Validation");
        return student -> student.getEmail().contains("@") ? SUCCESS : EMAIL_NOT_VALID;
    }
    static StudentRegistrationValidator isPhoneNumberValid() {
        logger.info("Running PhoneNumber Validation");
        return student -> student.getPhoneNumber().startsWith("+251") ? SUCCESS : PHONE_NUMBER_NOT_VALID;
    }
    static StudentRegistrationValidator isAnAdult() {
        logger.info("Running Age Validation");
        return student -> Period.between(student.getDob(), LocalDate.now()).getYears() > 16 ? SUCCESS : IS_NOT_AN_ADULT;
    }


     default StudentRegistrationValidator and (StudentRegistrationValidator other) {
        return student -> {
              ValidationResult result = this.apply(student);

        return result.equals(SUCCESS) ? other.apply(student) : result;
        };
        }
}
