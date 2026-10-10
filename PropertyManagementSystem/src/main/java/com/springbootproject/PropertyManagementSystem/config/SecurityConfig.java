package com.springbootproject.PropertyManagementSystem.config;

import com.springbootproject.PropertyManagementSystem.Services.JwtFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http)
    {
        http
                .csrf(csrf->csrf.disable())
                .authorizeHttpRequests(auth->auth
                .requestMatchers("/users/register")
                .permitAll()
                .requestMatchers("/users/login")
                .permitAll()
                        .requestMatchers("/property/getProperties")
                        .hasRole("ADMIN")
                        .requestMatchers("/property/getPropsBySellerId/**")
                        .hasAnyRole("ADMIN","SELLER","BUYER")
                        .requestMatchers("/property/propsByCategory/**")
                        .hasAnyRole("ADMIN,SELLER,BUYER")
                        .requestMatchers("/users/getUsers")
                        .hasRole("ADMIN")

                .anyRequest()
                .authenticated()
        );
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
       return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authMan(AuthenticationConfiguration config)
    {
        return config.getAuthenticationManager();
    }

}
