package com.example.PropertyManagementSystem.Dto;

import com.example.PropertyManagementSystem.CATEGORY;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class ConsumersDetailsDto {
    private String firstName;
    private String lastName;
    private String EmailId;
    private String password;
    private Boolean permission;
    private CATEGORY category;
    private Long propertyId;
}
