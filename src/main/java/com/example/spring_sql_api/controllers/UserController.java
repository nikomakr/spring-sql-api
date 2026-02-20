package com.example.spring_sql_api.controllers;

import com.example.spring_sql_api.DTOs.CreateUserRequest;
import com.example.spring_sql_api.DTOs.UserResponse;
import com.example.spring_sql_api.models.User;
import com.example.spring_sql_api.services.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @PostMapping
    public UserResponse createUser(@Validated @RequestBody CreateUserRequest newUserRequest) {
        return userService.addUser(newUserRequest);
    }
}
