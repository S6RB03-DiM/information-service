package com.dinnerinmotion.informationservice.service;
import com.dinnerinmotion.informationservice.entity.Restaurant;
import com.dinnerinmotion.informationservice.repository.RestaurantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public Restaurant findRestaurantById(UUID restaurantId) {
        log.info("inside find event by id method of RestaurantService");
        return restaurantRepository.findByRestaurantId(restaurantId);
    }
}
