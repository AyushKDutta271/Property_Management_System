package com.example.PropertyManagementSystem.Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

//@Setter
//@Getter
public class ConsumerLoginDto {
    @NotNull(message="Email is mandatory")
    private String emailId;

    @NotNull(message="Password is mandatory")
    @Size(min=5,message="Please enter password of minimum length 5")
    private String password;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
