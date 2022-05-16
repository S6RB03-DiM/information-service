package com.dinnerinmotion.informationservice.repository;

import com.dinnerinmotion.informationservice.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Reservation findByReservationId(Long id);
}
