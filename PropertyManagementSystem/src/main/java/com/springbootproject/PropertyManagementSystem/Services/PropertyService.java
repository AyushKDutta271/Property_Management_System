package com.springbootproject.PropertyManagementSystem.Services;

import com.springbootproject.PropertyManagementSystem.DTO.ClassConversions;
import com.springbootproject.PropertyManagementSystem.DTO.PropertyDto;
import com.springbootproject.PropertyManagementSystem.DTO.UserDto;
import com.springbootproject.PropertyManagementSystem.Entities.Category;
import com.springbootproject.PropertyManagementSystem.Entities.Property;
import com.springbootproject.PropertyManagementSystem.Entities.User;
import com.springbootproject.PropertyManagementSystem.Repositories.PropertyRepository;
import com.springbootproject.PropertyManagementSystem.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private ClassConversions classConversions;

    @Autowired
    private UserRepository userRepo;
    public Page<PropertyDto> getAllProperties(Pageable pageable)
    {

        return propertyRepository.findAll(pageable)
                                 .map(prop->classConversions.entityToPropertyDto(prop));

    }

    public PropertyDto getPropertyById(Long id)
    {
        Optional<Property> prop=propertyRepository.findById(id);
        if(prop.isPresent())
        {
            return classConversions.entityToPropertyDto(prop.get());
        }
        else
        {
            return null;
        }

    }

    public PropertyDto saveAsProperty(PropertyDto property,Long sellerId)
    {
        property.setSellerId(sellerId);
        return classConversions
                .entityToPropertyDto(propertyRepository
                        .save(classConversions
                                .dtoToPropertyEntity(property)
                        ));
    }

    public PropertyDto replaceProperty(PropertyDto property, Long id)
    {
        Optional<Property> prop=propertyRepository.findById(id);


        if(prop.isPresent())
        {
            return classConversions
                    .entityToPropertyDto(propertyRepository
                            .save(classConversions
                                    .dtoToPropertyEntity(property)));
        }
        else
        {
            return null;
        }
    }

    public String removeProperty(Long id)
    {
       PropertyDto prop= getPropertyById(id);
       if(prop!=null)
       {
           propertyRepository.deleteById(id);
           return "deleted successfully";
       }
       else
       {
           return "Property doesn't exist!";
       }
    }

    public Page<PropertyDto> propertiesByCategory(Category category,Pageable pageable)
    {
        return propertyRepository.findByPropertyCategory(category,pageable)
                .map(prop->classConversions.entityToPropertyDto(prop));
    }

    public Page<PropertyDto> propertiesBySellerId(Long sellerId,Pageable pageable)
    {
        User u= userRepo.findById(sellerId).orElseThrow(()->new NoSuchElementException("User with this id not found!"));
        return propertyRepository.findBySellerId(u,pageable).map(p->classConversions.entityToPropertyDto(p));
    }
}
