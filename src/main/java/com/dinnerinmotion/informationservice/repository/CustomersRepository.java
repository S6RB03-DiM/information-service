package com.dinnerinmotion.informationservice.repository;

import com.dinnerinmotion.informationservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<Customer, Long> {
    Customer findByCustomerId(Long id);
}
