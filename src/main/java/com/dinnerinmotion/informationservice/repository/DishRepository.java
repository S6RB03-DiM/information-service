package com.dinnerinmotion.informationservice.repository;

import com.dinnerinmotion.informationservice.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DishRepository extends JpaRepository<Dish, UUID> {
    Dish findByDishId(UUID id);
}
