package com.springbootproject.PropertyManagementSystem.Controllers;

import com.springbootproject.PropertyManagementSystem.DTO.LoginUserDto;
import com.springbootproject.PropertyManagementSystem.DTO.UserDto;
import com.springbootproject.PropertyManagementSystem.Services.AuthService;
import com.springbootproject.PropertyManagementSystem.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @GetMapping("/getUsers")
    public ResponseEntity<Page<UserDto>> listAllUsers(@PageableDefault(size = 10)Pageable pageable)
    {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers(pageable));
    }

    @PostMapping("/register/{propertyId}")
    public ResponseEntity<UserDto> registerUser(@Valid @RequestBody UserDto user,@PathVariable Long propertyId)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveAsUser(user,propertyId));
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody @Valid LoginUserDto user)
    {
        return authService.verify(user);
    }
}
