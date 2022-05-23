package com.dinnerinmotion.informationservice.repository;

import com.dinnerinmotion.informationservice.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReviewRepository extends JpaRepository<Review, UUID> {
    Review findByReviewId(UUID id);
}
