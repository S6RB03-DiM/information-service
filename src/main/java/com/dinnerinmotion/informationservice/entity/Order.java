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
@Table(name = "orders")
public class Order {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    @JsonProperty("id")
    private UUID id;
    @JsonProperty("restaurant_id")
    private UUID restaurantId;
    @JsonProperty("reservation_id")
    private UUID reservationId;
    @JsonProperty("dish_identifier")
    private String dish_identifier;
    @JsonProperty("name")
    private String name;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("state")
    private String state;
}
