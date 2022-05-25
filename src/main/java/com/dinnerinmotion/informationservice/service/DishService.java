package com.dinnerinmotion.informationservice.service;
import com.dinnerinmotion.informationservice.entity.Dish;
import com.dinnerinmotion.informationservice.repository.DishRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class DishService {
    @Autowired
    private DishRepository dishRepository;

    public Optional<Dish> findDishById(UUID dishId) {
        log.info("inside find dish by id method of dishService");
        return dishRepository.findById(dishId);
    }
}
