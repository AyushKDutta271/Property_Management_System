package com.example.PropertyManagementSystem.Service;

import com.example.PropertyManagementSystem.Dto.ConsumersDetailsDto;
import com.example.PropertyManagementSystem.Dto.ConsumersDto;
import com.example.PropertyManagementSystem.Dto.PropertyDetailsDto;
import com.example.PropertyManagementSystem.Dto.PropertyDto;
import com.example.PropertyManagementSystem.STATUS;


import java.util.List;
import java.util.Map;

public interface PropertyService {
   List<ConsumersDto> getAllConsumersByCategory(String category);
   List<PropertyDto> getAllPropertiesByCustomerId(Long CustomerId);
   PropertyDto getPropertyByPropertyId(Long PropertyId);
   ConsumersDto createConsumer(ConsumersDetailsDto consumer);
   PropertyDto postProperty(PropertyDetailsDto property);
   PropertyDto updatePropertyFieldByPropertyId(Long PropertyId, Map<String,Object> field);
   List<PropertyDto> listPropertiesWithStatus(STATUS status);
   PropertyDto updatePropertyByPropertyId(Long PropertyId, PropertyDetailsDto property);
   void removeProperty(Long PropertyId);
}
