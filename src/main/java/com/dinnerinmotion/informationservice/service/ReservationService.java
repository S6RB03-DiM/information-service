package com.dinnerinmotion.informationservice.service;
import com.dinnerinmotion.informationservice.entity.Reservation;
import com.dinnerinmotion.informationservice.repository.ReservationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation saveReservation(Reservation reservation) {
        log.info("inside save reservation method of ReservationEvent");
        return reservationRepository.save(reservation);
    }

    public Reservation findReservationById(Long reservationId) {
        log.info("inside find reservation by id method of ReservationEvent");
        return reservationRepository.findByReservationId(reservationId);
    }
}
