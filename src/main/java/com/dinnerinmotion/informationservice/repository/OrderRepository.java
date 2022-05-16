package com.dinnerinmotion.informationservice.repository;

import com.dinnerinmotion.informationservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByOrderId(Long id);
}
