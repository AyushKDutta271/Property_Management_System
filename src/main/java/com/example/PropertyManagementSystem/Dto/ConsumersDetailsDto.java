package com.example.PropertyManagementSystem.Dto;

import com.example.PropertyManagementSystem.CATEGORY;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class ConsumersDetailsDto {
    private String firstName;
    private String lastName;
    private String emailId;
    private String password;
    private Boolean permission;

    @Enumerated(EnumType.STRING)
    private CATEGORY category;
    private Long propertyId;
}
