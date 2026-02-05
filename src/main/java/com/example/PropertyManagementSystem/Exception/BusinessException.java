package com.example.PropertyManagementSystem.Exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class BusinessException extends Exception{
    private List<ErrorModel> errors;

    public BusinessException(List<ErrorModel> errors)
    {
        this.errors=errors;
    }

}
