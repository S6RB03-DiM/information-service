package com.dinnerinmotion.informationservice.listeners;

import com.dinnerinmotion.informationservice.entity.Order;
import com.dinnerinmotion.informationservice.entity.Reservation;
import com.dinnerinmotion.informationservice.repository.OrderRepository;
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
public class OrderListener {
    private final String groupKafka = "informationService-order";
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private OrderRepository orderRepository;

    @KafkaListener(id = groupKafka + "-create", topics = "dinnerinmotion.orders.create")
    public void createOrderEvent(String orderJSONString) throws JsonProcessingException {
        try {
            Order orderIn = objectMapper.readValue(orderJSONString, Order.class);
            orderRepository.save(orderIn);
        } catch (Exception e) {
            System.out.print("Error in Create Order: " + e);
        }
    }

    @KafkaListener(id = groupKafka + "-update", topics = "dinnerinmotion.orders.update")
    public void updateOrderEvent(String orderJSONString) throws JsonProcessingException {
        try {
            Order orderIn = objectMapper.readValue(orderJSONString, Order.class);
            orderRepository.save(orderIn);
        } catch (Exception e) {
            System.out.print("Error in Update Order: " + e);
        }
    }

    @KafkaListener(id = groupKafka + "-delete", topics = "dinnerinmotion.orders.delete")
    public void deleteOrderEvent(String orderJSONString) throws JsonProcessingException {
        try {
            Order orderIn = objectMapper.readValue(orderJSONString, Order.class);
            orderRepository.deleteById(orderIn.getReservationId());
        } catch (Exception e) {
            System.out.print("Error in Delete Order: " + e);
        }
    }
}
