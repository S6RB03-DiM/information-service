package com.dinnerinmotion.informationservice.controller;

import com.dinnerinmotion.informationservice.entity.Reservation;
import com.dinnerinmotion.informationservice.service.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/information/events")
@Slf4j
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/{reservationId}")
    public Reservation findEventById(@PathVariable("reservationId") UUID reservationId) {
        log.info("inside find reservation by id method of ReservationController");
        return reservationService.findReservationById(reservationId);
    }
}
