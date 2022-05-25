package com.dinnerinmotion.informationservice.listeners;

import com.dinnerinmotion.informationservice.entity.Reservation;
import com.dinnerinmotion.informationservice.entity.Restaurant;
import com.dinnerinmotion.informationservice.repository.ReservationRepository;
import com.dinnerinmotion.informationservice.repository.RestaurantRepository;
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
public class ReservationListener {
    private final String groupKafka = "informationService-reservation";
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private ReservationRepository reservationRepository;

    @KafkaListener(id = groupKafka + "-create", topics = "dinnerinmotion.reservations.create")
    public void createReservationEvent(String reservationJSONString) throws JsonProcessingException {
        try {
            JsonNode productNode = new ObjectMapper().readTree(reservationJSONString);

            System.out.println(productNode);
            Reservation newReservation = new Reservation();

            newReservation.setId(UUID.fromString(productNode.get("id").textValue()));
            newReservation.setRestaurant_id(UUID.fromString(productNode.get("restaurant_id").textValue()));
            newReservation.setCustomer_id(UUID.fromString(productNode.get("customer_id").textValue()));
            newReservation.setCustomers(productNode.get("group").toString());
            newReservation.setGroupSize(Integer.parseInt(String.valueOf(productNode.get("groupSize"))));
            newReservation.setTableNumber(productNode.get("tableNumber").textValue());
            newReservation.setCreated_at(productNode.get("created_at").textValue());
            newReservation.setState(Integer.parseInt(String.valueOf(productNode.get("state"))));
            newReservation.setComment(productNode.get("comment").textValue());
            newReservation.setSingle_household(Boolean.valueOf(productNode.get("single_household").textValue()));
            System.out.println(newReservation);
            reservationRepository.save(newReservation);
        } catch (Exception e) {
            System.out.print("Error in Create Reservation: " + e);
        }
    }

    @KafkaListener(id = groupKafka + "-update", topics = "dinnerinmotion.reservations.update")
    public void updateReservationEvent(String reservationJSONString) throws JsonProcessingException {
        try {
            Reservation reservationIn = objectMapper.readValue(reservationJSONString, Reservation.class);
            reservationRepository.save(reservationIn);
        } catch (Exception e) {
            System.out.print("Error in Update Reservation: " + e);
        }
    }

    @KafkaListener(id = groupKafka + "-delete", topics = "dinnerinmotion.reservations.delete")
    public void deleteReservationEvent(String reservationJSONString) throws JsonProcessingException {
        try {
            Reservation reservationIn = objectMapper.readValue(reservationJSONString, Reservation.class);
            reservationRepository.deleteById(reservationIn.getId());
        } catch (Exception e) {
            System.out.print("Error in Delete Reservation: " + e);
        }
    }
}
