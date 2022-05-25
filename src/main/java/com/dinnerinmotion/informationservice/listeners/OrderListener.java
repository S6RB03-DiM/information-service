package com.dinnerinmotion.informationservice.listeners;

import com.dinnerinmotion.informationservice.entity.Customer;
import com.dinnerinmotion.informationservice.entity.Order;
import com.dinnerinmotion.informationservice.entity.Reservation;
import com.dinnerinmotion.informationservice.repository.OrderRepository;
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
public class OrderListener {
    private final String groupKafka = "informationService-order";
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private OrderRepository orderRepository;

    @KafkaListener(id = groupKafka + "-create", topics = "dinnerinmotion.orders.create")
    public void createOrderEvent(String orderJSONString){
        try {
            handleJsonStringOrder(orderJSONString);
        } catch (Exception e) {
            System.out.print("Error in Create Order: " + e);
        }
    }

    @KafkaListener(id = groupKafka + "-update", topics = "dinnerinmotion.orders.update")
    public void updateOrderEvent(String orderJSONString){
        try {
            handleJsonStringOrder(orderJSONString);
        } catch (Exception e) {
            System.out.print("Error in Update Order: " + e);
        }
    }

    @KafkaListener(id = groupKafka + "-delete", topics = "dinnerinmotion.orders.delete")
    public void deleteOrderEvent(String orderJSONString){
        try {
            JsonNode productNode = objectMapper.readTree(orderJSONString);
            orderRepository.deleteById(UUID.fromString(productNode.get("id").textValue()));
            System.out.println("deleted order: " + orderJSONString);
        } catch (Exception e) {
            System.out.print("Error in Delete Order: " + e);
        }
    }


    private void handleJsonStringOrder(String orderJSONString) throws JsonProcessingException {
        JsonNode productNode = objectMapper.readTree(orderJSONString);

        System.out.println(productNode);
        Order orderIn = new Order();

        orderIn.setId(UUID.fromString(productNode.get("id").textValue()));
        orderIn.setReservationId(UUID.fromString(productNode.get("reservation_id").textValue()));
        orderIn.setRestaurantId(UUID.fromString(productNode.get("restaurant_id").textValue()));
        orderIn.setDish_identifier(productNode.get("dish_identifier").textValue());
        orderIn.setName(productNode.get("name").textValue());
        orderIn.setQuantity(Integer.parseInt(String.valueOf(productNode.get("quantity"))));
        orderIn.setPrice(Double.parseDouble(String.valueOf(productNode.get("price"))));
        orderIn.setState(productNode.get("state").textValue());

        orderRepository.save(orderIn);
        System.out.println("Handled Order: " + orderIn);
    }
}
