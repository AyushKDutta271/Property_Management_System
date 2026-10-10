package com.springbootproject.PropertyManagementSystem.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class LoginUserDto {
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",message = "please enter emailId in patter abc@gmail.com")
    @NotNull
    private String emailId;

    @NotNull
    @NotBlank
    @Length(max=7,message = "please provide password within 7 chars")
    private String password;
}
