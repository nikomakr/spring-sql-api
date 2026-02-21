package com.example.spring_sql_api.DTOs;

import jakarta.validation.constraints.*;


public class CreateRatingRequest {
    @NotNull(message = "Score is required")
    @Min(value = 0, message = "Score must be between 0 and 5")
    @Max(value = 5, message = "Score must be between 0 and 5")
    private int score;

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotNull(message = "Movie ID is required")
    private Long movieId;

    public CreateRatingRequest() {
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
}
