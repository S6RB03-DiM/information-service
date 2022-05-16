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
@Table(name = "dishes")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID dishId;
    private UUID restaurantId;
    private String name;
    private String dietaryRestrictions; //array of objects
    private Double price;

    public Dish(UUID restaurantId, String name, String dietaryRestrictions, Double price) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.dietaryRestrictions = dietaryRestrictions;
        this.price = price;
    }
}
