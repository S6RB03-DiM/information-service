package com.dinnerinmotion.informationservice.listeners;

import com.dinnerinmotion.informationservice.entity.Restaurant;
import com.dinnerinmotion.informationservice.repository.RestaurantRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.UUID;

@Configuration
@EnableKafka
public class RestaurantListener {
    private final String groupKafka = "informationService-restaurant";
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private RestaurantRepository restaurantRepository;

    @KafkaListener(id = groupKafka + "-create", topics = "dinnerinmotion.restaurants.create")
    public void createRestaurantEvent(String restaurantJSONString) {
        try {
            handleJsonStringRestaurant(restaurantJSONString);
        } catch (Exception e) {
            System.out.print("Error in Create Restaurant: " + e);
        }
    }

    @KafkaListener(id = groupKafka + "-update", topics = "dinnerinmotion.restaurants.update")
    public void updateRestaurantEvent(String restaurantJSONString) {
        try {
            handleJsonStringRestaurant(restaurantJSONString);
        } catch (Exception e) {
            System.out.print("Error in Update Restaurant: " + e);
        }
    }

    @KafkaListener(id = groupKafka + "-delete", topics = "dinnerinmotion.restaurants.delete")
    public void deleteRestaurantEvent(String restaurantJSONString) {
        try {
            JsonNode productNode = objectMapper.readTree(restaurantJSONString);
            restaurantRepository.deleteById(UUID.fromString(productNode.get("id").textValue()));
            System.out.println("deleted restaurant: " + restaurantJSONString);
        } catch (Exception e) {
            System.out.print("Error in Delete Restaurant: " + e);
        }
    }


    private void handleJsonStringRestaurant(String restaurantJSONString) throws JsonProcessingException {
        JsonNode productNode = objectMapper.readTree(restaurantJSONString);

        System.out.println(productNode);
        Restaurant restaurantIn = new Restaurant();

        restaurantIn.setId(UUID.fromString(productNode.get("id").textValue()));
        restaurantIn.setName(productNode.get("name").textValue());
        restaurantIn.setAddress(productNode.get("address").textValue());
        restaurantIn.setCapacity(Integer.parseInt(String.valueOf(productNode.get("capacity"))));
        restaurantIn.setStandardOpeningHours(productNode.get("standardOpeningHours").toString());
        restaurantIn.setStandardOpeningHours(productNode.get("standardOpeningHours").toString());

        restaurantRepository.save(restaurantIn);
        System.out.println("Handled Restaurant: " + restaurantIn);
    }
}
