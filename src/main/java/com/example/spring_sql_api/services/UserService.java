package com.example.spring_sql_api.services;

import com.example.spring_sql_api.DTOs.CreateUserRequest;
import com.example.spring_sql_api.DTOs.UserResponse;
import com.example.spring_sql_api.models.User;
import com.example.spring_sql_api.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    //READ on GET request
    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    // CREATE ON POST Request
    public UserResponse addUser(CreateUserRequest newUserRequest) {

        if (userRepo.existsByEmail(newUserRequest.getEmail())) {
            throw new IllegalArgumentException("Email already in use: " + newUserRequest.getEmail());
        }

        User user = new User();
        user.setName(newUserRequest.getName());
        user.setEmail(newUserRequest.getEmail());

        User saved = userRepo.save(user);

        return mapToResponse(saved);
    }

    private UserResponse mapToResponse(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }


}
