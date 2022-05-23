package com.dinnerinmotion.informationservice.repository;

import com.dinnerinmotion.informationservice.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, UUID> {
    Restaurant findByRestaurantId(UUID id);
}
