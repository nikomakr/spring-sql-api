package com.example.spring_sql_api.services;

import com.example.spring_sql_api.DTOs.CreateRatingRequest;
import com.example.spring_sql_api.DTOs.RatingResponse;
import com.example.spring_sql_api.models.Movie;
import com.example.spring_sql_api.models.Rating;
import com.example.spring_sql_api.models.User;
import com.example.spring_sql_api.repositories.MovieRepository;
import com.example.spring_sql_api.repositories.RatingRepository;
import com.example.spring_sql_api.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {
    private final RatingRepository ratingRepo;
    private final MovieRepository movieRepo;
    private final UserRepository userRepo;

    public RatingService(RatingRepository ratingRepo, MovieRepository movieRepo,
                         UserRepository userRepo) {
        this.ratingRepo = ratingRepo;
        this.movieRepo = movieRepo;
        this.userRepo = userRepo;
    }

    public RatingResponse getRatingById(Long id) {
        Rating saved =
                ratingRepo.findById(id)
                        .orElseThrow(()
                                -> new EntityNotFoundException(String.format("Rating with ID %d not found", id)));
        return mapToResponse(saved);
    }

    public List<RatingResponse> getAllRatings() {
        return ratingRepo.findAll().stream().map(this::mapToResponse).toList();
    }

    public RatingResponse createRating(CreateRatingRequest ratingRequest) {
        Long movieId = ratingRequest.getMovieId();
        Long userId = ratingRequest.getUserId();

        Movie movie = movieRepo.findById(movieId).orElseThrow(() ->
                new EntityNotFoundException(String.format("Movie with ID: %d was " +
                        "not found", movieId))
        );

        User user = userRepo.findById(userId).orElseThrow(() ->
                new EntityNotFoundException(String.format("User with ID: %d " +
                        "was not found", userId))
        );

        if (ratingRepo.existsByUserAndMovie(user, movie)) {
            throw new RuntimeException(String.format("User %s has " +
                            "already rated movie: %s", user.getName(),
                    movie.getTitle()));
        }

        Rating rating = new Rating();
        rating.setScore(ratingRequest.getScore());
        rating.setMovie(movie);
        rating.setUser(user);
        ratingRepo.save(rating);

        return mapToResponse(rating);
    }

    private RatingResponse mapToResponse(Rating r) {
        return new RatingResponse(r.getId(), r.getScore(), r.getMovie().getId(),
               r.getMovie().getTitle());
    }
}
