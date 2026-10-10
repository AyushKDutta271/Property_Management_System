package com.springbootproject.PropertyManagementSystem.Services;

import com.springbootproject.PropertyManagementSystem.DTO.ClassConversions;

import com.springbootproject.PropertyManagementSystem.DTO.UserDto;

import com.springbootproject.PropertyManagementSystem.Entities.Property;
import com.springbootproject.PropertyManagementSystem.Entities.User;

import com.springbootproject.PropertyManagementSystem.Repositories.PropertyRepository;
import com.springbootproject.PropertyManagementSystem.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {


        @Autowired
        private UserRepository userRepository;

        @Autowired
        private ClassConversions classConversions;

        @Autowired
        private PropertyRepository propertyRepository;

        @Autowired
        private BCryptPasswordEncoder bCryptPasswordEncoder;

        public Page<UserDto> getAllUsers(Pageable pageable)
        {
            Page<User> users= userRepository.findAll(pageable);
            return users
                    .map(u->classConversions.entityToUserDto(u));
        }

        public UserDto getUserById(Long id)
        {
            Optional<User> user=userRepository.findById(id);
            if(user.isPresent())
            {
                return classConversions.entityToUserDto(user.get());
            }
            else
            {
                return null;
            }

        }

        public UserDto saveAsUser(UserDto user,Long propertyId)
        {
            if(propertyId!=null) {
                Property prop = propertyRepository.findById(propertyId).orElseThrow(() -> new NoSuchElementException("No user found with this sellerId"));
                user.setProperty(List.of(prop));
            }
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            return classConversions
                    .entityToUserDto(userRepository
                            .save(classConversions
                                    .dtoToUserEntity(user)
                            ));
        }

        public UserDto replaceProperty(UserDto user, Long id)
        {
            Optional<User> u=userRepository.findById(id);
            if(u.isPresent())
            {
                return classConversions
                        .entityToUserDto(userRepository
                                .save(classConversions
                                        .dtoToUserEntity(user)));
            }
            else
            {
                return null;
            }
        }

        public String removeUser(Long id)
        {
            UserDto user= getUserById(id);
            if(user!=null)
            {
                userRepository.deleteById(id);
                return "deleted successfully";
            }
            else
            {
                return "Property doesn't exist!";
            }
        }
    }


