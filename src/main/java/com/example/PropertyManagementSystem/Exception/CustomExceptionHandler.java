package com.example.PropertyManagementSystem.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> businessExceptionHandler(BusinessException ex)
    {
        System.out.println("This is a Business type exception!");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
    }
}
