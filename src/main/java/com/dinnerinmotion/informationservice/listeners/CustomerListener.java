package com.dinnerinmotion.informationservice.listeners;

import com.dinnerinmotion.informationservice.entity.Customer;
import com.dinnerinmotion.informationservice.entity.Dish;
import com.dinnerinmotion.informationservice.repository.CustomersRepository;
import com.dinnerinmotion.informationservice.repository.DishRepository;
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
public class CustomerListener {
    private final String groupKafka = "informationService-customer";
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private CustomersRepository customersRepository;

    @KafkaListener(id = groupKafka + "-create", topics = "dinnerinmotion.customers.create")
    public void createCustomerEvent(String customerJSONString) throws JsonProcessingException {
        try {
            Customer customerIn = objectMapper.readValue(customerJSONString, Customer.class);
            customersRepository.save(customerIn);
        } catch (Exception e) {
            System.out.print("Error in Create Customer: " + e);
        }
    }

    @KafkaListener(id = groupKafka + "-update", topics = "dinnerinmotion.customers.update")
    public void updateDishEvent(String customerJSONString) throws JsonProcessingException {
        try {
            Customer customerIn = objectMapper.readValue(customerJSONString, Customer.class);
            customersRepository.save(customerIn);
        } catch (Exception e) {
            System.out.print("Error in Update Customer: " + e);
        }
    }

    @KafkaListener(id = groupKafka + "-delete", topics = "dinnerinmotion.customers.delete")
    public void deleteDishEvent(String customerJSONString) throws JsonProcessingException {
        try {
            Customer customerIn = objectMapper.readValue(customerJSONString, Customer.class);
            customersRepository.deleteById(customerIn.getCustomerId());
        } catch (Exception e) {
            System.out.print("Error in Delete Customer: " + e);
        }
    }
}
