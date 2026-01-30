package com.example.PropertyManagementSystem.Dto;

import com.example.PropertyManagementSystem.PropertyType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class PropertyDto {
    private Long id;
    private Long sellerId;
    private PropertyType type;
    private Long ownerId;

}
