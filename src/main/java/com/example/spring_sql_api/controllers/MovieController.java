package com.example.spring_sql_api.controllers;

import com.example.spring_sql_api.DTOs.CreateMovieRequest;
import com.example.spring_sql_api.models.Movie;
import com.example.spring_sql_api.services.MovieService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.findMovieById(id);
    }

//    @GetMapping


    @PostMapping
    public Movie createMovie(@RequestBody CreateMovieRequest newMovie) {
        return movieService.createMovie(newMovie);
    }

}
