package com.dinnerinmotion.informationservice.controller;

import com.dinnerinmotion.informationservice.entity.Restaurant;
import com.dinnerinmotion.informationservice.service.RestaurantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/information/restaurants")
@Slf4j
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/{restaurantId}")
    public Optional<Restaurant> findRestaurantById(@PathVariable("restaurantId") UUID restaurantId) {
        log.info("inside find restaurant by id method of restaurantController");
        return restaurantService.findRestaurantById(restaurantId);
    }
}
