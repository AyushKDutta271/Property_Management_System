package com.springbootproject.PropertyManagementSystem.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface Password {
    String message() default "Passwords didn't match!";

    String field1();
    String field2();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload () default {};


}
