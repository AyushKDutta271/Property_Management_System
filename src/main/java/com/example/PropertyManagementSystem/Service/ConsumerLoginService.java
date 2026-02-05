package com.example.PropertyManagementSystem.Service;

import com.example.PropertyManagementSystem.Dto.ConsumersDto;

public interface ConsumerLoginService {
    ConsumersDto consumerLogin(String email, String password) throws Exception;
    ConsumersDto consumerLogout();
}
