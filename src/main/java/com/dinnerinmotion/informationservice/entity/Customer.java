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
    @Column(columnDefinition = "BINARY(16)")
    private UUID customerId;
    private String name;
    private String email;
    private String dietaryRestrictions; //should be array
}
