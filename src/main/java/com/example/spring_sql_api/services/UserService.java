package com.example.spring_sql_api.services;

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
    public List<User> findAllUsers(){
        return userRepo.findAll();
    }

}
