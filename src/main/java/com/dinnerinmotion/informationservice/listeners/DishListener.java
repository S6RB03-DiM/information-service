package com.dinnerinmotion.informationservice.listeners;

import com.dinnerinmotion.informationservice.entity.Dish;
import com.dinnerinmotion.informationservice.entity.Reservation;
import com.dinnerinmotion.informationservice.repository.DishRepository;
import com.dinnerinmotion.informationservice.repository.ReservationRepository;
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
public class DishListener {
    private final String groupKafka = "informationService-dish";
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private DishRepository dishRepository;

    @KafkaListener(id = groupKafka + "-create", topics = "dinnerinmotion.dishes.create")
    public void createDishEvent(String dishJSONString) throws JsonProcessingException {
        try {
            Dish dishIn = objectMapper.readValue(dishJSONString, Dish.class);
            dishRepository.save(dishIn);
        } catch (Exception e) {
            System.out.print("Error in Create Dish: " + e);
        }
    }

    @KafkaListener(id = groupKafka + "-update", topics = "dinnerinmotion.dishes.update")
    public void updateDishEvent(String dishJSONString) throws JsonProcessingException {
        try {
            Dish dishIn = objectMapper.readValue(dishJSONString, Dish.class);
            dishRepository.save(dishIn);
        } catch (Exception e) {
            System.out.print("Error in Update Dish: " + e);
        }
    }

    @KafkaListener(id = groupKafka + "-delete", topics = "dinnerinmotion.dishes.delete")
    public void deleteDishEvent(String dishJSONString) throws JsonProcessingException {
        try {
            Dish dishIn = objectMapper.readValue(dishJSONString, Dish.class);
            dishRepository.deleteById(dishIn.getDishId());
        } catch (Exception e) {
            System.out.print("Error in Delete Dish: " + e);
        }
    }
}
