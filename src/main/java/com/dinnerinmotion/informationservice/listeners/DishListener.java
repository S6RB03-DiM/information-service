package com.dinnerinmotion.informationservice.listeners;

import com.dinnerinmotion.informationservice.entity.Dish;
import com.dinnerinmotion.informationservice.entity.Order;
import com.dinnerinmotion.informationservice.entity.Reservation;
import com.dinnerinmotion.informationservice.repository.DishRepository;
import com.dinnerinmotion.informationservice.repository.ReservationRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;

import java.util.List;
import java.util.UUID;

@Configuration
@EnableKafka
public class DishListener {
    private final String groupKafka = "informationService-dish";
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private DishRepository dishRepository;

    @KafkaListener(id = groupKafka + "-create", topics = "dinnerinmotion.dishes.create")
    public void createDishEvent(String dishJSONString) {
        try {
            handleJsonStringDish(dishJSONString);
        } catch (Exception e) {
            System.out.print("Error in Create Dish: " + e);
        }
    }

    @KafkaListener(id = groupKafka + "-update", topics = "dinnerinmotion.dishes.update")
    public void updateDishEvent(String dishJSONString) {
        try {
            handleJsonStringDish(dishJSONString);
        } catch (Exception e) {
            System.out.print("Error in Update Dish: " + e);
        }
    }

    @KafkaListener(id = groupKafka + "-delete", topics = "dinnerinmotion.dishes.delete")
    public void deleteDishEvent(String dishJSONString) {
        try {
            JsonNode productNode = objectMapper.readTree(dishJSONString);
            dishRepository.deleteById(UUID.fromString(productNode.get("id").textValue()));
            System.out.println("deleted dish: " + dishJSONString);
        } catch (Exception e) {
            System.out.print("Error in Delete Dish: " + e);
        }
    }


    private void handleJsonStringDish(String dishJSONString) throws JsonProcessingException {
        JsonNode productNode = objectMapper.readTree(dishJSONString);

        System.out.println(productNode);
        Dish dishIn = new Dish();

        dishIn.setId(UUID.fromString(productNode.get("id").textValue()));
        dishIn.setRestaurantId(UUID.fromString(productNode.get("restaurant_id").textValue()));
        dishIn.setName(productNode.get("name").textValue());
        dishIn.setDietaryRestrictions(productNode.get("dietaryRestrictions").toString());
        dishIn.setPrice(Double.parseDouble(String.valueOf(productNode.get("price"))));

        dishRepository.save(dishIn);
        System.out.println("Handled Dish: " + dishIn);
    }
}
