package com.dinnerinmotion.informationservice.service;
import com.dinnerinmotion.informationservice.entity.Customer;
import com.dinnerinmotion.informationservice.repository.CustomersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomersService {
    @Autowired
    private CustomersRepository customersRepository;

    public Customer saveCustomer(Customer customer) {
        log.info("inside save customer method of customerService");
        return customersRepository.save(customer);
    }

    public Customer findCustomerById(Long customerId) {
        log.info("inside find customer by id method of customerService");
        return customersRepository.findByCustomerId(customerId);
    }
}
