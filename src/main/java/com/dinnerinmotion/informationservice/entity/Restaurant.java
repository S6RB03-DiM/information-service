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
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID restaurantId;
    private String name;
    private String address;
    private Integer capacity;
    private int standardOpeningHours;
}
