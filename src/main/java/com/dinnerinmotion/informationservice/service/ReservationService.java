package com.dinnerinmotion.informationservice.service;
import com.dinnerinmotion.informationservice.entity.Reservation;
import com.dinnerinmotion.informationservice.repository.ReservationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public Optional<Reservation> findReservationById(UUID id) {
        log.info("inside find reservation by id method of ReservationEvent");
        return reservationRepository.findById(id);
    }
}
