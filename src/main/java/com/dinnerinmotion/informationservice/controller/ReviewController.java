package com.dinnerinmotion.informationservice.controller;

import com.dinnerinmotion.informationservice.entity.Review;
import com.dinnerinmotion.informationservice.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/information/reviews")
@Slf4j
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/{reviewId}")
    public Optional<Review> findReviewById(@PathVariable("reviewId") UUID reviewId) {
        log.info("inside find review by id method of ReviewController");
        log.info(String.valueOf(reviewId));
        return reviewService.findReviewById(reviewId);
    }
}
