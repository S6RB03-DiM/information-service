package com.dinnerinmotion.informationservice.service;
import com.dinnerinmotion.informationservice.entity.Customer;
import com.dinnerinmotion.informationservice.repository.CustomersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomersService {
    @Autowired
    private CustomersRepository customersRepository;

    public Customer findCustomerById(UUID customerId) {
        log.info("inside find customer by id method of customerService");
        return customersRepository.findByCustomerId(customerId);
    }
}
