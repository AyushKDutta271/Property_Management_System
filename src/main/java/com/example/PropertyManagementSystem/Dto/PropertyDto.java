package com.example.PropertyManagementSystem.Dto;

import com.example.PropertyManagementSystem.PropertyType;
import com.example.PropertyManagementSystem.STATUS;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class PropertyDto {
    private Long id;
    private Long sellerId;
    private STATUS status;
    private PropertyType type;
    private Long ownerId;

}
