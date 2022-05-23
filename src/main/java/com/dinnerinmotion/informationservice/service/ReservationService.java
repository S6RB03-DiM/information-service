package com.dinnerinmotion.informationservice.service;
import com.dinnerinmotion.informationservice.entity.Reservation;
import com.dinnerinmotion.informationservice.repository.ReservationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation findReservationById(UUID reservationId) {
        log.info("inside find reservation by id method of ReservationEvent");
        return reservationRepository.findByReservationId(reservationId);
    }
}
