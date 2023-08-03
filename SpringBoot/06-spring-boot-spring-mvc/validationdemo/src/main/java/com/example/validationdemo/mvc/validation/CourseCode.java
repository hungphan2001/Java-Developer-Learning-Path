package com.example.validationdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    //define default course code
    public String value() default  "CODE";

    //define default error message
   public String message() default "must start with CODE";
    //define default groups
   public Class<?>[] groups() default {};
    //define default payloads
    public Class<? extends Payload>[] payload() default {};
}
