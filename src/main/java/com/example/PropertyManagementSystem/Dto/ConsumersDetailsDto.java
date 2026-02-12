package com.example.PropertyManagementSystem.Dto;

import com.example.PropertyManagementSystem.CATEGORY;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Setter
public class ConsumersDetailsDto {
    private String firstName;
    private String lastName;
    private String emailId;
    private String password;
    private Boolean permission;


    private CATEGORY category;
    private Long propertyId;
}
