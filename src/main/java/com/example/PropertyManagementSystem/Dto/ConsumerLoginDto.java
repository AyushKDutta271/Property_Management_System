package com.example.PropertyManagementSystem.Dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class ConsumerLoginDto {
    private String emailId;
    private String password;
}
