package com.dinnerinmotion.informationservice;

import com.dinnerinmotion.informationservice.entity.Review;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class InformationServiceApplicationTests {
	ObjectMapper objectMapper = new ObjectMapper();

//	@Test
//	void reviewJSONStringConvertsToEntity() throws JsonProcessingException {
//		String reviewJSONString = "{\n" +
//				"  \"reviewId\": \"5e7e1f40-da91-11ec-9d64-0242ac120002\",\n" +
//				"  \"restaurant_id\": \"31e24732-da8b-11ec-9d64-0242ac120002\",\n" +
//				"  \"customer_id\": \"45aa1ff6-da8b-11ec-9d64-0242ac120002\",\n" +
//				"  \"rating\": \"5\",\n" +
//				"  \"description\": \"wowsies\"\n" +
//				"}";
//		Review reviewIn = objectMapper.readValue(reviewJSONString, Review.class);
//		assertEquals(reviewIn.getId().toString(),  "5e7e1f40-da91-11ec-9d64-0242ac120002");
//	}

}
