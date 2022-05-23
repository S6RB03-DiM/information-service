package com.dinnerinmotion.informationservice.controller;

import com.dinnerinmotion.informationservice.entity.Customer;
import com.dinnerinmotion.informationservice.service.CustomersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/information/customers")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomersService customersService;

    @GetMapping("/{customerId}")
    public Customer findCustomerById(@PathVariable("customerId") UUID customerId) {
        log.info("inside find customer by id method of CustomerController");
        return customersService.findCustomerById(customerId);
    }
}
