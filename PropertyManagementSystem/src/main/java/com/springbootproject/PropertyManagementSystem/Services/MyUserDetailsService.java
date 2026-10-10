package com.springbootproject.PropertyManagementSystem.Services;


import com.springbootproject.PropertyManagementSystem.Entities.User;
import com.springbootproject.PropertyManagementSystem.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user =userRepository.findByEmailId(username);
        if(user.isPresent())
            return user.get();
        else
            throw new UsernameNotFoundException("user with this email not found!");
    }
}
