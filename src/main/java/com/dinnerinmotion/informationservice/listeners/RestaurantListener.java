package com.dinnerinmotion.informationservice.listeners;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;

import java.util.List;

@Configuration
@EnableKafka
public class RestaurantListener {
    private final String groupKafka = "informationService";

    /*LISTENER FOR RESTAURANTS CREATE EVENT*/
    @KafkaListener(id = groupKafka, topics = "dinnerinmotion.RestaurantListener.create")
    public void createRestaurantEvent(String message,
                                      @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List partitions,
                                      @Header(KafkaHeaders.RECEIVED_TOPIC) List topics,
                                      @Header(KafkaHeaders.OFFSET) List offsets) {

        System.out.printf("%s-%d[%d] \"%s\"\n", topics.get(0), partitions.get(0), offsets.get(0), message);
    }

    /*LISTENER FOR RESTAURANTS UPDATE EVENT*/
    @KafkaListener(id = groupKafka, topics = "dinnerinmotion.RestaurantListener.update")
    public void updateRestaurantEvent(String message,
                                      @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List partitions,
                                      @Header(KafkaHeaders.RECEIVED_TOPIC) List topics,
                                      @Header(KafkaHeaders.OFFSET) List offsets) {

        System.out.printf("%s-%d[%d] \"%s\"\n", topics.get(0), partitions.get(0), offsets.get(0), message);
    }

    /*LISTENER FOR RESTAURANTS DELETE EVENT*/
    @KafkaListener(id = groupKafka, topics = "dinnerinmotion.RestaurantListener.delete")
    public void deleteRestaurantEvent(String message,
                                      @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List partitions,
                                      @Header(KafkaHeaders.RECEIVED_TOPIC) List topics,
                                      @Header(KafkaHeaders.OFFSET) List offsets) {

        System.out.printf("%s-%d[%d] \"%s\"\n", topics.get(0), partitions.get(0), offsets.get(0), message);
    }
}
