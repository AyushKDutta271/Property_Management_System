package com.springbootproject.PropertyManagementSystem.Entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
public class User implements UserDetails {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;


    private String firstName;
    private String lastName;
    private String emailId;
    private String password;

    @Transient
    private String confirmPassword;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @OneToOne(mappedBy = "sellerId")
    private List<Property> property;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+userType.toString().toUpperCase()));
        return authorities;
    }

    @Override
    public String getUsername() {
        return emailId;
    }
}
