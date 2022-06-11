package com.dinnerinmotion.informationservice;

import com.dinnerinmotion.informationservice.entity.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;



@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureDataJpa
@AutoConfigureTestDatabase
class InformationServiceObjectMapperTests {

	ObjectMapper objectMapper = new ObjectMapper();

	@Test
	void customerJSONStringConvertsToEntity() throws JsonProcessingException {
		String customerJSONString = "{\n" +
				"  \"id\": \"5e7e1f40-da91-11ec-9d64-0242ac120002\",\n" +
				"  \"name\": \"31e24732-da8b-11ec-9d64-0242ac120002\",\n" +
				"  \"email\": \"45aa1ff6-da8b-11ec-9d64-0242ac120002\",\n" +
				"  \"dietaryRestrictions\": \"none\"\n" +
				"}";
		Customer customerIn = objectMapper.readValue(customerJSONString, Customer.class);
		assertEquals(customerIn.getId().toString(),  "5e7e1f40-da91-11ec-9d64-0242ac120002");
	}

	@Test
	void dishJSONStringConvertsToEntity() throws JsonProcessingException {
		String dishJSONString = "{\n" +
				"  \"id\": \"5e7e1f40-da91-11ec-9d64-0242ac120002\",\n" +
				"  \"restaurant_id\": \"31e24732-da8b-11ec-9d64-0242ac120002\",\n" +
				"  \"name\": \"45aa1ff6-da8b-11ec-9d64-0242ac120002\",\n" +
				"  \"dietaryRestrictions\": \"none\",\n" +
				"  \"price\": \"634\"\n" +
				"}";
		Dish reviewIn = objectMapper.readValue(dishJSONString, Dish.class);
		assertEquals(reviewIn.getId().toString(),  "5e7e1f40-da91-11ec-9d64-0242ac120002");
	}

	@Test
	void orderJSONStringConvertsToEntity() throws JsonProcessingException {
		String orderJSONString = "{\n" +
				"  \"id\": \"5e7e1f40-da91-11ec-9d64-0242ac120002\",\n" +
				"  \"restaurant_id\": \"31e24732-da8b-11ec-9d64-0242ac120002\",\n" +
				"  \"reservation_id\": \"45aa1ff6-da8b-11ec-9d64-0242ac120002\",\n" +
				"  \"dish_identifier\": \"lorem ipsum\",\n" +
				"  \"name\": \"quis nostrud\",\n" +
				"  \"quantity\": \"13\",\n" +
				"  \"price\": \"5.67\",\n" +
				"  \"state\": \"officia\"\n" +
				"}";
		Order reviewIn = objectMapper.readValue(orderJSONString, Order.class);
		assertEquals(reviewIn.getId().toString(),  "5e7e1f40-da91-11ec-9d64-0242ac120002");
	}

	@Test
	void reservationJSONStringConvertsToEntity() throws JsonProcessingException {
		String reservationJSONString = "{\n" +
				"  \"id\": \"5e7e1f40-da91-11ec-9d64-0242ac120002\",\n" +
				"  \"restaurant_id\": \"31e24732-da8b-11ec-9d64-0242ac120002\",\n" +
				"  \"customer_id\": \"45aa1ff6-da8b-11ec-9d64-0242ac120002\",\n" +
				"  \"groupSize\": \"5\",\n" +
				"  \"customers\": \"Carol\",\n" +
				"  \"tableNumber\": \"1\",\n" +
				"  \"created_at\": \"2022-04-02\",\n" +
				"  \"state\": \"1\",\n" +
				"  \"comment\": \"none\",\n" +
				"  \"single_household\": \"false\"\n" +
				"}";
		Reservation reservationIn = objectMapper.readValue(reservationJSONString, Reservation.class);
		assertEquals(reservationIn.getId().toString(),  "5e7e1f40-da91-11ec-9d64-0242ac120002");
	}

	@Test
	void restaurantJSONStringConvertsToEntity() throws JsonProcessingException {
		String restaurantJSONString = "{\n" +
				"  \"id\": \"5e7e1f40-da91-11ec-9d64-0242ac120002\",\n" +
				"  \"name\": \"Dinner in Motion\",\n" +
				"  \"address\": \"Piazza\",\n" +
				"  \"capacity\": \"5\",\n" +
				"  \"standardOpeningHours\": \"12:00-19:00\"\n" +
				"}";
		Restaurant restaurantIn = objectMapper.readValue(restaurantJSONString, Restaurant.class);
		assertEquals(restaurantIn.getId().toString(),  "5e7e1f40-da91-11ec-9d64-0242ac120002");
	}

	@Test
	void reviewJSONStringConvertsToEntity() throws JsonProcessingException {
		String reviewJSONString = "{\n" +
				"  \"id\": \"5e7e1f40-da91-11ec-9d64-0242ac120002\",\n" +
				"  \"restaurant_id\": \"31e24732-da8b-11ec-9d64-0242ac120002\",\n" +
				"  \"customer_id\": \"45aa1ff6-da8b-11ec-9d64-0242ac120002\",\n" +
				"  \"rating\": \"5\",\n" +
				"  \"description\": \"wow\"\n" +
				"}";
		Review reviewIn = objectMapper.readValue(reviewJSONString, Review.class);
		assertEquals(reviewIn.getId().toString(),  "5e7e1f40-da91-11ec-9d64-0242ac120002");
	}


}
