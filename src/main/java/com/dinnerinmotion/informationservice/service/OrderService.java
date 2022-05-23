package com.dinnerinmotion.informationservice.service;
import com.dinnerinmotion.informationservice.entity.Order;
import com.dinnerinmotion.informationservice.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order findOrderById(UUID orderId) {
        log.info("inside find event by id method of orderService");
        return orderRepository.findByOrderId(orderId);
    }
}
