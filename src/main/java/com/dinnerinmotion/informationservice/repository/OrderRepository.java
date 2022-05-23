package com.dinnerinmotion.informationservice.repository;

import com.dinnerinmotion.informationservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    Order findByOrderId(UUID id);
}
