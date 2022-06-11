package com.dinnerinmotion.informationservice;

import com.dinnerinmotion.informationservice.service.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureDataJpa
@AutoConfigureTestDatabase
public class ServiceTests {

    CustomersService customersService;
    DishService dishService;
    OrderService orderService;
    ReservationService reservationService;
    ReviewService reviewService;

    @Test
    void customersEntityIsSavedInRepository(){

    }
}
