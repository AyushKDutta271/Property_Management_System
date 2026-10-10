package com.springbootproject.PropertyManagementSystem.DTO;

import com.springbootproject.PropertyManagementSystem.Entities.Category;
import com.springbootproject.PropertyManagementSystem.Entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PropertyDto {

    @NotNull
    @NotBlank
    private String propertyName;

    @NotNull
    @NotBlank
    private String propertyDescription;


    @NotNull
    private Category propertyCategory;

    @NotNull
    private Long sellerId;
}
