package com.example.PropertyManagementSystem.Dto;

import com.example.PropertyManagementSystem.PropertyType;
import com.example.PropertyManagementSystem.STATUS;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
public class PropertyDetailsDto {
    @NotNull(message="Every property must have a seller")
    private Long sellerId;

    @NotNull(message="Please choose the status")
    private STATUS status;

    @NotNull(message="choose property type")
    private PropertyType type;

    private Long ownerId;
}
