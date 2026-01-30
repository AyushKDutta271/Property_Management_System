package com.example.PropertyManagementSystem.Dto;

import com.example.PropertyManagementSystem.PropertyType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class PropertyDetailsDto {
    private Long sellerId;
    private PropertyType type;
    private Long ownerId;
}
