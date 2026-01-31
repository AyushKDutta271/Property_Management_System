package com.example.PropertyManagementSystem.AdapterDesign;

import com.example.PropertyManagementSystem.Dto.ConsumersDetailsDto;
import com.example.PropertyManagementSystem.Dto.ConsumersDto;
import com.example.PropertyManagementSystem.Dto.PropertyDetailsDto;
import com.example.PropertyManagementSystem.Dto.PropertyDto;
import com.example.PropertyManagementSystem.Entity.ConsumersEntity;
import com.example.PropertyManagementSystem.Entity.PropertyEntity;
import com.example.PropertyManagementSystem.Repository.ConsumerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassesConversions {
    @Autowired
    private ConsumerRepo consRepo;

    @Autowired
    private PropertyEntity propRepo;

    public ConsumersEntity fromConsumersDtoToConsumerEntity(ConsumersDetailsDto consumer)
    {
        ConsumersEntity entity = new ConsumersEntity();
        entity.setFirstName(consumer.getFirstName());
        entity.setLastName(consumer.getLastName());
        entity.setPermission(consumer.getPermission());
        entity.setCategory(consumer.getCategory());
        entity.setPropertyId(consumer.getPropertyId());

        return entity;
    }

    public ConsumersDto fromConsumersEntityToConsumersDto(ConsumersEntity cons)
    {
        return new ConsumersDto(cons.getId(),cons.getFirstName(),cons.getLastName(),cons.getPermission(),cons.getCategory(),cons.getPropertyId());
    }

    public PropertyEntity fromPropertyDtoToPropertyEntity(PropertyDetailsDto property)
    {
        PropertyEntity prop = new PropertyEntity();
        prop.setType(property.getType());
        prop.setOwnerId(property.getOwnerId());
        prop.setSellerId(property.getSellerId());
        return prop;
    }

    public PropertyDto fromPropertyEntityToPropertyDto(PropertyEntity prop)
    {
        return  new PropertyDto(prop.getId(),prop.getSellerId(),prop.getType(),prop.getOwnerId());
    }

}
