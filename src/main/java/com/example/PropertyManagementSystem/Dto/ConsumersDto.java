package com.example.PropertyManagementSystem.Dto;

import com.example.PropertyManagementSystem.CATEGORY;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)//Not include null value properties in json data
@JsonIgnoreProperties(ignoreUnknown=true)//ignore properties with unknown values
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class ConsumersDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;

    private String password;
    private Boolean permission;

    @Enumerated(EnumType.STRING)
    private CATEGORY category;
    private Long propertyId;
}
