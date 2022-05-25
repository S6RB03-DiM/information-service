package com.dinnerinmotion.informationservice.listeners;

import com.dinnerinmotion.informationservice.entity.Customer;
import com.dinnerinmotion.informationservice.repository.CustomersRepository;
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
public class CustomerListener {
    private final String groupKafka = "informationService-customer";
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private CustomersRepository customersRepository;

    @KafkaListener(id = groupKafka + "-create", topics = "dinnerinmotion.customers.create")
    public void createCustomerEvent(String customerJSONString) {
        try {
            handleJsonStringCustomer(customerJSONString);
        } catch (Exception e) {
            System.out.print("Error in Create customer: " + e);
        }
    }

    @KafkaListener(id = groupKafka + "-update", topics = "dinnerinmotion.customers.update")
    public void updateDishEvent(String customerJSONString) {
        try {
            handleJsonStringCustomer(customerJSONString);
        } catch (Exception e) {
            System.out.print("Error in Update customer: " + e);
        }
    }

    @KafkaListener(id = groupKafka + "-delete", topics = "dinnerinmotion.customers.delete")
    public void deleteDishEvent(String customerJSONString) {
        try {
            JsonNode productNode = objectMapper.readTree(customerJSONString);
            customersRepository.deleteById(UUID.fromString(productNode.get("id").textValue()));
            System.out.println("deleted customer: " + customerJSONString);
        } catch (Exception e) {
            System.out.print("Error in Delete Customer: " + e);
        }
    }


    private void handleJsonStringCustomer(String customerJSONString) throws JsonProcessingException {
        JsonNode productNode = objectMapper.readTree(customerJSONString);

        System.out.println(productNode);
        Customer customerIn = new Customer();

        customerIn.setId(UUID.fromString(productNode.get("id").textValue()));
        customerIn.setName(productNode.get("name").textValue());
        customerIn.setEmail(productNode.get("email").textValue());
        customerIn.setDietaryRestrictions(productNode.get("dietaryRestrictions").toString());

        customersRepository.save(customerIn);
        System.out.println("Handled Customer: " + customerIn);
    }
}
