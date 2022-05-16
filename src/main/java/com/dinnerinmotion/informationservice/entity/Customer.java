package com.dinnerinmotion.informationservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID customerId;
    private String name;
    private String email;
    private String dietaryRestrictions; //should be array

    public Customer(String name, String email, String dietaryRestrictions) {
        this.name = name;
        this.email = email;
        this.dietaryRestrictions = dietaryRestrictions;
    }
}
