package com.example.PropertyManagementSystem.Service;

import com.example.PropertyManagementSystem.AdapterDesign.ClassesConversions;
import com.example.PropertyManagementSystem.Dto.ConsumersDto;
import com.example.PropertyManagementSystem.Entity.ConsumersEntity;
import com.example.PropertyManagementSystem.Exception.BusinessException;
import com.example.PropertyManagementSystem.Exception.ErrorModel;
import com.example.PropertyManagementSystem.Exception.InvalidLoginException;
import com.example.PropertyManagementSystem.Repository.ConsumerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsumerLoginServiceImpl implements ConsumerLoginService{

    private ConsumerRepo consRepo;
    @Autowired
    private ClassesConversions classConvo;

    @Autowired
    ConsumerLoginServiceImpl( ConsumerRepo consRepo)
    {
        this.consRepo=consRepo;
    }
    @Override
    public ConsumersDto consumerLogin(String email, String password) throws RuntimeException {

        Optional<ConsumersEntity> entity = consRepo.findByEmailIdAndPassword(email, password);

        ConsumersDto consumerResult;
        if (entity.isPresent()) {
            consumerResult = classConvo.fromConsumersEntityToConsumersDto(entity.get());
        } else {
            List<ErrorModel> errorsType = new ArrayList<>();
            ErrorModel error = new ErrorModel();
            error.setErrorCode("LOGIN_TYPE_ERROR");
            error.setMessage("Incorrect email or password!");
            errorsType.add(error);

            throw new BusinessException(errorsType);
        }
        return consumerResult;
    }

    @Override
    public ConsumersDto consumerLogout() {
        return null;
    }
}
