package com.dinnerinmotion.informationservice.service;
import com.dinnerinmotion.informationservice.entity.Review;
import com.dinnerinmotion.informationservice.repository.ReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public Review saveEvent(Review review) {
        log.info("inside save review method of reviewService");
        return reviewRepository.save(review);
    }

    public Review findEventById(Long reviewId) {
        log.info("inside find review by id method of reviewService");
        return reviewRepository.findByReviewId(reviewId);
    }
}
