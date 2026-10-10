package com.springbootproject.PropertyManagementSystem.DTO;

import com.springbootproject.PropertyManagementSystem.Entities.Property;
import com.springbootproject.PropertyManagementSystem.Entities.User;
import com.springbootproject.PropertyManagementSystem.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class ClassConversions {

    @Autowired
    private UserRepository userRepository;

    public PropertyDto entityToPropertyDto(Property property)
    {
        return new PropertyDto(property.getPropertyName(),property.getPropertyDescription(),property.getPropertyCategory(),property.getSellerId().getId());
    }

    public Property dtoToPropertyEntity(PropertyDto property)
    {
        Property prop = new Property();
        prop.setPropertyName(property.getPropertyName());
        prop.setPropertyDescription(property.getPropertyDescription());
        prop.setPropertyCategory(property.getPropertyCategory());
        prop.setPropertyCategory(property.getPropertyCategory());
        User u=userRepository.findById(property.getSellerId()).orElseThrow(()->new NoSuchElementException("User with this id not found!"));
        prop.setSellerId(u);

        return prop;
    }

    public UserDto entityToUserDto(User user)
    {
       return new UserDto(user.getFirstName(),user.getLastName(),user.getEmailId(),user.getPassword(),user.getConfirmPassword(),user.getUserType(),user.getProperty());
    }

    public User dtoToUserEntity(UserDto user)
    {
        User u = new User();
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        u.setEmailId(user.getEmailId());
        u.setPassword(user.getPassword());
        u.setConfirmPassword(user.getConfirmPassword());
        u.setProperty(user.getProperty());
        u.setUserType(user.getUserType());
        return u;
    }
}
