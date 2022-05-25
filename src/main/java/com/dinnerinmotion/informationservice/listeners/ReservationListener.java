package com.dinnerinmotion.informationservice.listeners;

import com.dinnerinmotion.informationservice.entity.Reservation;
import com.dinnerinmotion.informationservice.repository.ReservationRepository;
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
public class ReservationListener {
    private final String groupKafka = "informationService-reservation";
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private ReservationRepository reservationRepository;

    @KafkaListener(id = groupKafka + "-create", topics = "dinnerinmotion.reservations.create")
    public void createReservationEvent(String reservationJSONString) {
        try {
            handleJsonStringReservation(reservationJSONString);
        } catch (Exception e) {
            System.out.print("Error in Create Reservation: " + e);
        }
    }

    @KafkaListener(id = groupKafka + "-update", topics = "dinnerinmotion.reservations.update")
    public void updateReservationEvent(String reservationJSONString) {
        try {
            handleJsonStringReservation(reservationJSONString);
        } catch (Exception e) {
            System.out.print("Error in Update Reservation: " + e);
        }
    }

    @KafkaListener(id = groupKafka + "-delete", topics = "dinnerinmotion.reservations.delete")
    public void deleteReservationEvent(String reservationJSONString) throws JsonProcessingException {
        try {
            JsonNode productNode = objectMapper.readTree(reservationJSONString);
            reservationRepository.deleteById(UUID.fromString(productNode.get("id").textValue()));
            System.out.println("deleted reservation: " + reservationJSONString);
        } catch (Exception e) {
            System.out.print("Error in Delete Reservation: " + e);
        }
    }


    private void handleJsonStringReservation(String reservationJSONString) throws JsonProcessingException {
        JsonNode productNode = objectMapper.readTree(reservationJSONString);

        System.out.println(productNode);
        Reservation reservationIn = new Reservation();

        reservationIn.setId(UUID.fromString(productNode.get("id").textValue()));
        reservationIn.setRestaurant_id(UUID.fromString(productNode.get("restaurant_id").textValue()));
        reservationIn.setCustomer_id(UUID.fromString(productNode.get("customer_id").textValue()));
        reservationIn.setCustomers(productNode.get("group").toString());
        reservationIn.setGroupSize(Integer.parseInt(String.valueOf(productNode.get("groupSize"))));
        reservationIn.setTableNumber(productNode.get("tableNumber").textValue());
        reservationIn.setCreated_at(productNode.get("created_at").textValue());
        reservationIn.setState(Integer.parseInt(String.valueOf(productNode.get("state"))));
        reservationIn.setComment(productNode.get("comment").textValue());
        reservationIn.setSingle_household(Boolean.valueOf(productNode.get("single_household").textValue()));

        reservationRepository.save(reservationIn);
        System.out.println("Handled Reservation: " + reservationIn);
    }
}
