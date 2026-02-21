package com.example.spring_sql_api.controllers;

import com.example.spring_sql_api.DTOs.CreateRatingRequest;
import com.example.spring_sql_api.DTOs.RatingResponse;
import com.example.spring_sql_api.services.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {
    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping
    public ResponseEntity<RatingResponse> createRating(@Validated @RequestBody CreateRatingRequest ratingRequest) {
        RatingResponse response = ratingService.createRating(ratingRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RatingResponse> getRatingById(@PathVariable Long id) {
        RatingResponse response = ratingService.getRatingById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public List<RatingResponse> getAllRatings() {
        return ratingService.getAllRatings();
    }
}
