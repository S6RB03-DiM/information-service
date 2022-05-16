package com.dinnerinmotion.informationservice.repository;

import com.dinnerinmotion.informationservice.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
    Dish findByDishId(Long id);
}
