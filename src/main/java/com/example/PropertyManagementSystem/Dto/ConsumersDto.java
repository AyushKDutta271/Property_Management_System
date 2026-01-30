package com.example.PropertyManagementSystem.Dto;

import com.example.PropertyManagementSystem.CATEGORY;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class ConsumersDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Boolean permission;
    private CATEGORY category;
    private Long propertyId;
}
