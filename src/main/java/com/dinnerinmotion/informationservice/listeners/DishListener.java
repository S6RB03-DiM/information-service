package com.dinnerinmotion.informationservice.listeners;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;

import java.util.List;

@Configuration
@EnableKafka
public class DishListener {
    private final String groupKafka = "informationService";

    /*LISTENER FOR DISHES CREATE EVENT*/
    @KafkaListener(id = groupKafka, topics = "dinnerinmotion.dishes.create")
    public void createDishesEvent(String message,
                                  @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List partitions,
                                  @Header(KafkaHeaders.RECEIVED_TOPIC) List topics,
                                  @Header(KafkaHeaders.OFFSET) List offsets) {

        System.out.printf("%s-%d[%d] \"%s\"\n", topics.get(0), partitions.get(0), offsets.get(0), message);
    }
}
