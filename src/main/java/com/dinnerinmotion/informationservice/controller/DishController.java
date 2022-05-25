package com.dinnerinmotion.informationservice.controller;

import com.dinnerinmotion.informationservice.entity.Dish;
import com.dinnerinmotion.informationservice.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/information/dishes")
@Slf4j
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping("/{dishId}")
    public Optional<Dish> findDishById(@PathVariable("dishId") UUID dishId) {
        log.info("inside find dish by id method of DishController");
        return dishService.findDishById(dishId);
    }
}
