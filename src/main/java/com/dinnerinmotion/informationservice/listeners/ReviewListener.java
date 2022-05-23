package com.dinnerinmotion.informationservice.listeners;

import com.dinnerinmotion.informationservice.entity.Review;
import com.dinnerinmotion.informationservice.repository.ReviewRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
@EnableKafka
public class ReviewListener {
    private final String groupKafka = "informationService-review";
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private ReviewRepository reviewRepository;

    @KafkaListener(id = groupKafka + "-create", topics = "dinnerinmotion.review.create")
    public void createReviewEvent(String reviewJSONString) throws JsonProcessingException {
        try {
            Review reviewIn = objectMapper.readValue(reviewJSONString, Review.class);
            reviewRepository.save(reviewIn);
        } catch (Exception e) {
            System.out.print("Error in Create Review: " + e);
        }
    }

    @KafkaListener(id = groupKafka + "-update", topics = "dinnerinmotion.review.update")
    public void updateReviewEvent(String reviewJSONString) throws JsonProcessingException {
        try {
            Review reviewIn = objectMapper.readValue(reviewJSONString, Review.class);
            reviewRepository.save(reviewIn);
        } catch (Exception e) {
            System.out.print("Error in Update Review: " + e);
        }
    }

    @KafkaListener(id = groupKafka + "-delete", topics = "dinnerinmotion.review.delete")
    public void deleteReviewEvent(String reviewJSONString) throws JsonProcessingException {
        try {
            Review reviewIn = objectMapper.readValue(reviewJSONString, Review.class);
            reviewRepository.deleteById(reviewIn.getReviewId());
        } catch (Exception e) {
            System.out.print("Error in Delete Review: " + e);
        }
    }
}

