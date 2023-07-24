package com.example.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    //add exception handling code here

    //Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorRespone> handleException(StudentNotFoundException exc){

        //Create a StudentErrorResponse
        StudentErrorRespone error = new StudentErrorRespone();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    //Add another exception handler

    @ExceptionHandler
    public ResponseEntity<StudentErrorRespone> handleException(Exception e){
        //Create a StudentErrorResponse
        StudentErrorRespone errorRespone = new StudentErrorRespone();
        errorRespone.setStatus(HttpStatus.BAD_REQUEST.value());
        errorRespone.setMessage(e.getMessage());
        errorRespone.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorRespone,HttpStatus.BAD_REQUEST);
    }


}
