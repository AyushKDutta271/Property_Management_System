package com.example.PropertyManagementSystem.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {
    private final Logger logger= LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorModel>> fieldsValidationException(MethodArgumentNotValidException ex)
    {
       List<ErrorModel> list = new ArrayList<>();
       List<FieldError> errors= ex.getBindingResult().getFieldErrors();

       errors.forEach(e->{
           logger.info("Inside field validation Exception: {} - {}",e.getDefaultMessage(),e.getField());
           logger.debug("Inside debug field validation Exception: {} - {}",e.getDefaultMessage(),e.getField());
           ErrorModel model = new ErrorModel();
           model.setErrorCode(e.getCode());
           model.setMessage(e.getDefaultMessage());
           list.add(model);
       });

       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(list);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> businessExceptionHandler(BusinessException ex)
    {
        for(ErrorModel em : ex.getErrors())
        {
            logger.info("Inside Business Exception -info level: {} - {}",em.getErrorCode(),em.getMessage());
            logger.debug("Inside Business Exception -debug level: {} - {}", em.getErrorCode(),em.getMessage());
            logger.warn("Inside Business Exception -warn level: {} - {}", em.getErrorCode(),em.getMessage());
            logger.trace("Inside Business Exception -trace level: {} - {}", em.getErrorCode(),em.getMessage());
            logger.error("Inside Business Exception -error level: {} - {}", em.getErrorCode(),em.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
    }
}
