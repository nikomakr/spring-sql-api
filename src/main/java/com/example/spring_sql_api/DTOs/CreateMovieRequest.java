package com.example.spring_sql_api.DTOs;

import jakarta.validation.constraints.*;


public class CreateMovieRequest {
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 100, message =
            "Name must be between 3 and 100 char long")
    private String title;

    @Positive(message = "Release Year must be a positive number")
    private int releaseYear;

    private String director;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
