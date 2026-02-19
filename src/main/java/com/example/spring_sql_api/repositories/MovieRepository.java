package com.example.spring_sql_api.repositories;

import com.example.spring_sql_api.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
