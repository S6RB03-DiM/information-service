package com.dinnerinmotion.informationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class InformationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InformationServiceApplication.class, args);
	}

//	private final String groupKafka = "informationService";
//
//	@KafkaListener(id = groupKafka, topics = "mockTopic")
//	public void processMessage(String message,
//							   @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List partitions,
//							   @Header(KafkaHeaders.RECEIVED_TOPIC) List topics,
//							   @Header(KafkaHeaders.OFFSET) List offsets) {
//
//		System.out.printf("%s-%d[%d] \"%s\"\n", topics.get(0), partitions.get(0), offsets.get(0), message);
//
//		Event newEvent = new Event(UUID.randomUUID(), (String) topics.get(0), message);
//		eventController.createEvent(newEvent);
//	}
}
