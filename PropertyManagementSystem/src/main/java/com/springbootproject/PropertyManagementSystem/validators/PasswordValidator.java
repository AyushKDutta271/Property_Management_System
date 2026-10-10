package com.springbootproject.PropertyManagementSystem.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

public class PasswordValidator implements ConstraintValidator<Password,Object> {

    private String field1;
    private String field2;


    @Override
    public void initialize(Password constraintAnnotation) {
       this.field1=constraintAnnotation.field1();
       this.field2=constraintAnnotation.field2();
    }

    @Override
    public boolean isValid(Object arg0, ConstraintValidatorContext context) {
        Object f1= new BeanWrapperImpl(arg0).getPropertyValue(field1);
        Object f2= new BeanWrapperImpl(arg0).getPropertyValue(field2);

        return f1.equals(f2);
    }
}
