package com.example.PropertyManagementSystem.AdapterDesign;

import com.example.PropertyManagementSystem.Dto.ConsumersDetailsDto;
import com.example.PropertyManagementSystem.Dto.ConsumersDto;
import com.example.PropertyManagementSystem.Dto.PropertyDetailsDto;
import com.example.PropertyManagementSystem.Dto.PropertyDto;
import com.example.PropertyManagementSystem.Entity.ConsumersEntity;
import com.example.PropertyManagementSystem.Entity.PropertyEntity;

import com.example.PropertyManagementSystem.Repository.ConsumerRepo;
import com.example.PropertyManagementSystem.Repository.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassesConversions {

    @Autowired
    ConsumerRepo consRepo;


    public ConsumersEntity fromConsumersDtoToConsumerEntity(ConsumersDetailsDto consumer)
    {
        ConsumersEntity entity = new ConsumersEntity();
        entity.setFirstName(consumer.getFirstName());
        entity.setLastName(consumer.getLastName());
        entity.setEmailId(consumer.getEmailId());
        entity.setPassword(consumer.getPassword());
        entity.setPermission(consumer.getPermission());
        entity.setCategory(consumer.getCategory());
        entity.setPropertyId(consumer.getPropertyId());

        return entity;
    }

    public ConsumersDto fromConsumersEntityToConsumersDto(ConsumersEntity cons)
    {
        return new ConsumersDto(cons.getId(),cons.getFirstName(),cons.getLastName(),cons.getEmailId(),null,cons.getPermission(),cons.getCategory(),cons.getPropertyId());
    }

    public PropertyEntity fromPropertyDtoToPropertyEntity(PropertyDetailsDto property)
    {
        ConsumersEntity consEn= consRepo.findById(property.getOwner()).orElseThrow(()->new IllegalArgumentException());
        PropertyEntity prop = new PropertyEntity(property.getSellerId(),property.getStatus(),property.getType(),consEn);

        return prop;
    }

    public PropertyDto fromPropertyEntityToPropertyDto(PropertyEntity prop)
    {
       ConsumersEntity consEn=prop.getOwner();
       Long id= consEn.getId();
        return  new PropertyDto(prop.getId(),prop.getSellerId(),prop.getStatus(),prop.getType(),id);
    }

}


