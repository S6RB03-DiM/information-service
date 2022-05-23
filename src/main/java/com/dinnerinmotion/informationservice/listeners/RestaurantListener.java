package com.dinnerinmotion.informationservice.listeners;

import com.dinnerinmotion.informationservice.entity.Restaurant;
import com.dinnerinmotion.informationservice.repository.RestaurantRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;

import java.util.List;

@Configuration
@EnableKafka
public class RestaurantListener {
    private final String groupKafka = "informationService-restaurant";
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private RestaurantRepository restaurantRepository;

    @KafkaListener(id = groupKafka + "-create", topics = "dinnerinmotion.restaurants.create")
    public void createRestaurantEvent(String restaurantJSONString) throws JsonProcessingException {
        try {
            Restaurant restaurantIn = objectMapper.readValue(restaurantJSONString, Restaurant.class);
            restaurantRepository.save(restaurantIn);
        } catch (Exception e) {
            System.out.print("Error in Create Restaurant: " + e);
        }
    }

    @KafkaListener(id = groupKafka + "-update", topics = "dinnerinmotion.restaurants.update")
    public void updateRestaurantEvent(String restaurantJSONString) throws JsonProcessingException {
        try {
            Restaurant restaurantIn = objectMapper.readValue(restaurantJSONString, Restaurant.class);
            restaurantRepository.save(restaurantIn);
        } catch (Exception e) {
            System.out.print("Error in Update Restaurant: " + e);
        }
    }

    @KafkaListener(id = groupKafka + "-delete", topics = "dinnerinmotion.restaurants.delete")
    public void deleteRestaurantEvent(String restaurantJSONString) throws JsonProcessingException {
        try {
            Restaurant restaurantIn = objectMapper.readValue(restaurantJSONString, Restaurant.class);
            restaurantRepository.deleteById(restaurantIn.getRestaurantId());
        } catch (Exception e) {
            System.out.print("Error in Delete Restaurant: " + e);
        }
    }
}
