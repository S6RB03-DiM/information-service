package com.dinnerinmotion.informationservice.controller;

import com.dinnerinmotion.informationservice.entity.Review;
import com.dinnerinmotion.informationservice.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/information/reviews")
@Slf4j
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/{reviewId}")
    public Review findReviewById(@PathVariable("reviewId") Long reviewId) {
        log.info("inside find review by id method of ReviewController");
        return reviewService.findEventById(reviewId);
    }

//    private void createEvent(Event event) {
//        log.info("inside create event method of EventController");
//        eventService.saveEvent(event);
//    }
}
