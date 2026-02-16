package com.example.PropertyManagementSystem.Dto;

import com.example.PropertyManagementSystem.CATEGORY;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
public class ConsumersDetailsDto {
    @NotNull(message="first name is mandatory")
    private String firstName;

    @NotNull(message="last name is mandatory")
    private String lastName;

    @NotNull(message="Email is mandatory")
    private String emailId;

    @NotNull(message="Password is mandatory")
    @Size(min=5,message="Please enter password of minimum length 5")
    private String password;

    @NotNull(message="please make sure you've permission")
    private Boolean permission;

    @NotNull(message="Please choose category")
    private CATEGORY category;

    @NotNull(message = "Enter property-id if you're seller")
    private Long propertyId;
}
