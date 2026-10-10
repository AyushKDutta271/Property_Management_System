package com.springbootproject.PropertyManagementSystem.DTO;

import com.springbootproject.PropertyManagementSystem.Entities.Property;
import com.springbootproject.PropertyManagementSystem.Entities.UserType;
import com.springbootproject.PropertyManagementSystem.validators.Password;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;


import java.util.List;

@Data
@AllArgsConstructor
@Password(field1="password",field2="confirmPassword")
public class UserDto {

    @NotNull
    @NotBlank
    @Length(min=3,max=7,message = "please provide name between 3 and 7 chars")
    private String firstName;

    @NotNull
    @NotBlank
    @Length(min=3,max=7,message = "please provide name between 3 and 7 chars")
    private String lastName;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",message = "please enter emailId in patter abc@gmail.com")
    @NotNull
    private String emailId;

    @NotNull
    @NotBlank
    @Length(max=7,message = "please provide password within 7 chars")
    private String password;

    @NotNull
    @NotBlank
    @Length(max=7,message = "please provide password within 7 chars")
    private String confirmPassword;

    @NotNull
    private UserType userType;


    private List<Property> property;
}
