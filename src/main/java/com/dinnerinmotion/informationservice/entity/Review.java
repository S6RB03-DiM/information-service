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
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID reviewId;
    private UUID restaurant_id;
    private UUID customer_id;
    private Double rating;
    private String description;

    public Review(UUID restaurant_id, UUID customer_id, Double rating, String description) {
        this.restaurant_id = restaurant_id;
        this.customer_id = customer_id;
        this.rating = rating;
        this.description = description;
    }
}
