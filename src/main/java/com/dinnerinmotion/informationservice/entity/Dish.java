package com.dinnerinmotion.informationservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @Column(columnDefinition = "BINARY(16)")
    @JsonProperty("id")
    private UUID id;
    @JsonProperty("restaurant_id")
    private UUID restaurantId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("dietaryRestrictions")
    private String dietaryRestrictions;
    @JsonProperty("price")
    private Double price;
}
