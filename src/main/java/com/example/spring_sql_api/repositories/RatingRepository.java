package com.example.spring_sql_api.repositories;

import com.example.spring_sql_api.models.Movie;
import com.example.spring_sql_api.models.Rating;
import com.example.spring_sql_api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    boolean existsByUserAndMovie(User user, Movie movie);
}
