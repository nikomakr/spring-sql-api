package com.example.spring_sql_api.DTOs;

import java.util.List;

public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private List<RatingResponse> ratings;

    // Constructor without ratings
    public UserResponse(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.ratings = null;
    }

    // Constructor with ratings
    public UserResponse(Long id, String name, String email, List<RatingResponse> ratings) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.ratings = ratings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<RatingResponse> getRatings() {
        return ratings;
    }
}
