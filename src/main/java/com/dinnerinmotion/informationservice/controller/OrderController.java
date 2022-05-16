package com.dinnerinmotion.informationservice.controller;

import com.dinnerinmotion.informationservice.entity.Order;
import com.dinnerinmotion.informationservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/information/orders")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{orderId}")
    public Order findOrderById(@PathVariable("orderId") Long orderId) {
        log.info("inside find order by id method of OrderController");
        return orderService.findOrderById(orderId);
    }
}
