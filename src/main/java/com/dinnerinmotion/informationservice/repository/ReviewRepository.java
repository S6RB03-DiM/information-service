package com.dinnerinmotion.informationservice.repository;

import com.dinnerinmotion.informationservice.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Review findByReviewId(Long id);
}
