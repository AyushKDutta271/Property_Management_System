package com.example.PropertyManagementSystem.Service;

import com.example.PropertyManagementSystem.AdapterDesign.ClassesConversions;
import com.example.PropertyManagementSystem.Dto.ConsumersDetailsDto;
import com.example.PropertyManagementSystem.Dto.ConsumersDto;
import com.example.PropertyManagementSystem.Dto.PropertyDetailsDto;
import com.example.PropertyManagementSystem.Dto.PropertyDto;
import com.example.PropertyManagementSystem.CATEGORY;
import com.example.PropertyManagementSystem.Entity.ConsumersEntity;
import com.example.PropertyManagementSystem.Entity.PropertyEntity;
import com.example.PropertyManagementSystem.Exception.BusinessException;
import com.example.PropertyManagementSystem.Exception.ErrorModel;
import com.example.PropertyManagementSystem.PropertyType;
import com.example.PropertyManagementSystem.Repository.ConsumerRepo;
import com.example.PropertyManagementSystem.Repository.PropertyRepo;
import com.example.PropertyManagementSystem.STATUS;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService{

    @Autowired
    private ClassesConversions classConvo;
    @Autowired
    private PropertyRepo propRepo;

    @Autowired
    private ConsumerRepo consRepo;
    @Override
    public List<ConsumersDto> getAllConsumersByCategory(String category) {
        List<ConsumersEntity> consumers= new ArrayList<>();
        switch(category.toLowerCase())
        {
            case "buyers": consumers= consRepo.findAllConsumersByCategory(CATEGORY.BUYERS);
            break;

            case "sellers": consumers= consRepo.findAllConsumersByCategory(CATEGORY.SELLERS);
            break;

            default: System.out.println("It has to be either BUYERS or SELLERS");
        }

        return consumers.stream().map(e->classConvo.fromConsumersEntityToConsumersDto(e)).toList();
    }

    @Override
    public List<PropertyDto> getAllPropertiesByCustomerId(Long CustomerId) {
        List<PropertyEntity>  list= propRepo.findAllPropertiesBySellerId(CustomerId);
      return list.stream().map(e->classConvo.fromPropertyEntityToPropertyDto(e)).toList();
    }

    @Override
    public PropertyDto getPropertyByPropertyId(Long PropertyId) {
        PropertyEntity property= propRepo.findById(PropertyId).orElseThrow(()->new IllegalArgumentException("Property not found!"));
        return classConvo.fromPropertyEntityToPropertyDto(property);
    }

    @Override
    public ConsumersDto createConsumer(ConsumersDetailsDto consumer) {
        Optional<ConsumersEntity> entity1= consRepo.findByEmailId(consumer.getEmailId());
        if(entity1.isPresent())
        {
            ErrorModel error = new ErrorModel();
            error.setErrorCode("USER_ALREADY_EXISTS");
            error.setMessage("EmailId is already registered! Plz login or enter new EmailId");
            List<ErrorModel> list = new ArrayList<>();
            list.add(error);

            throw new BusinessException(list);
        }
     ConsumersEntity entity= classConvo.fromConsumersDtoToConsumerEntity(consumer);
        ConsumersEntity cons= consRepo.save(entity);
        return classConvo.fromConsumersEntityToConsumersDto(cons);
    }

    @Override
    public PropertyDto postProperty(PropertyDetailsDto property) {
      PropertyEntity prop= classConvo.fromPropertyDtoToPropertyEntity(property);
       return  classConvo.fromPropertyEntityToPropertyDto(prop);
    }

    @Override
    public PropertyDto updatePropertyFieldByPropertyId(Long PropertyId, Map<String, Object> field) {
       PropertyEntity prop= propRepo.findById(PropertyId).orElseThrow(()-> new IllegalArgumentException("Property not found!"));
        field.forEach((k,v)->
        {
            switch(k)
            {
                case "sellerId": prop.setSellerId((Long)v);break;
                case "type": if(PropertyType.LAND==PropertyType.valueOf((String)v))
                                 prop.setType(PropertyType.LAND);
                              else if(PropertyType.SHOP==PropertyType.valueOf((String)v))
                                 prop.setType(PropertyType.SHOP);
                              else
                                  prop.setType(PropertyType.HOUSE);
                              break;
                case "ownerId": prop.setOwnerId((Long)v);break;
            }
        });
     return classConvo.fromPropertyEntityToPropertyDto(prop);
    }

    @Override
    public List<PropertyDto> listPropertiesWithStatus(STATUS status) {
       List<PropertyEntity> property= propRepo.findAllByStatus(String.valueOf(status));
      return property.stream().map(e->classConvo.fromPropertyEntityToPropertyDto(e)).toList();
    }

    @Override
    public PropertyDto updatePropertyByPropertyId(Long PropertyId, PropertyDetailsDto property) {
       PropertyEntity prop =propRepo.findById(PropertyId).orElseThrow(()->new IllegalArgumentException("Property Not Found!"));
      prop.setSellerId(property.getSellerId());
      prop.setType(property.getType());
      prop.setOwnerId(property.getOwnerId());
      //doubt : is this how we should do...just modifying body and not adding it as new entry in table?!
        //how does it work internally in the context of transient and persistent states.
     PropertyEntity propertyEntity= propRepo.save(prop);
     return classConvo.fromPropertyEntityToPropertyDto(propertyEntity);
    }

    @Override
    public void removeProperty(Long PropertyId) {
        propRepo.findById(PropertyId).orElseThrow(()->new IllegalArgumentException("Property not found!"));
        propRepo.deleteById(PropertyId);
    }
}




