package com.example.PropertyManagementSystem.AdapterDesign;

import com.example.PropertyManagementSystem.Dto.ConsumersDetailsDto;
import com.example.PropertyManagementSystem.Dto.ConsumersDto;
import com.example.PropertyManagementSystem.Dto.PropertyDetailsDto;
import com.example.PropertyManagementSystem.Dto.PropertyDto;
import com.example.PropertyManagementSystem.Entity.ConsumersEntity;
import com.example.PropertyManagementSystem.Entity.PropertyEntity;

import org.springframework.stereotype.Component;

@Component
public class ClassesConversions {


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
        PropertyEntity prop = new PropertyEntity();
        prop.setType(property.getType());
        prop.setOwnerId(property.getOwnerId());
        prop.setSellerId(property.getSellerId());
        prop.setStatus(property.getStatus());
        return prop;
    }

    public PropertyDto fromPropertyEntityToPropertyDto(PropertyEntity prop)
    {
        return  new PropertyDto(prop.getId(),prop.getSellerId(),prop.getStatus(),prop.getType(),prop.getOwnerId());
    }

}
