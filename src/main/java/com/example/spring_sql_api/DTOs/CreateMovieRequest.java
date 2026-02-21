package com.example.spring_sql_api.DTOs;

import jakarta.validation.constraints.*;


public class CreateMovieRequest {
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 100, message =
            "Name must be between 3 and 100 char long")
    private String title;

    @Positive(message = "Release Year must be a positive number")
    private int releaseYear;

    @Size(max = 100, message =
            "Director's name must be 100 char max")
    private String director;

    @Size(max = 100, message =
            "Movie language must be 100 char max")
    private String language;

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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
