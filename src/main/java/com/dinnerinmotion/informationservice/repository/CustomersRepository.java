package com.dinnerinmotion.informationservice.repository;

import com.dinnerinmotion.informationservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomersRepository extends JpaRepository<Customer, UUID> {
    Customer findByCustomerId(UUID id);
}
