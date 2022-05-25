package com.dinnerinmotion.informationservice.service;
import com.dinnerinmotion.informationservice.entity.Review;
import com.dinnerinmotion.informationservice.repository.ReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public Optional<Review> findReviewById(UUID reviewId) {
        log.info("inside find review by id method of reviewService");
        return reviewRepository.findById(reviewId);
    }
}
