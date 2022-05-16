package com.dinnerinmotion.informationservice.service;
import com.dinnerinmotion.informationservice.entity.Dish;
import com.dinnerinmotion.informationservice.repository.DishRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DishService {
    @Autowired
    private DishRepository dishRepository;

    public Dish saveEvent(Dish dish) {
        log.info("inside save dish method of dishService");
        return dishRepository.save(dish);
    }

    public Dish findDishById(Long dishId) {
        log.info("inside find dish by id method of dishService");
        return dishRepository.findByDishId(dishId);
    }
}
