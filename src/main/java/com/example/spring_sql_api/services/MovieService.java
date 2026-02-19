package com.example.spring_sql_api.services;

import com.example.spring_sql_api.DTOs.CreateMovieRequest;
import com.example.spring_sql_api.models.Movie;
import com.example.spring_sql_api.repositories.MovieRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepo;

    public MovieService(MovieRepository movieRepo) {
        this.movieRepo = movieRepo;
    }

    public Movie createMovie(CreateMovieRequest newMovie) {
//        Add validation HERE
        Movie movie = new Movie();
        movie.setTitle(newMovie.getTitle());
        movie.setReleaseYear(newMovie.getReleaseYear());
        movie.setDirector(newMovie.getDirector());
        return movieRepo.save(movie);
    }

    public Movie findMovieById(Long id) {
        return movieRepo.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format(
                "Movie with ID: %d, was not found", id
        )));
    }

    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }

    public void deleteMovie(Long id) {
        if (!movieRepo.existsById(id)) {
            throw new EntityNotFoundException(String.format("Movie with ID: %d, was not found", id));
        }
        movieRepo.deleteById(id);
    }

}
