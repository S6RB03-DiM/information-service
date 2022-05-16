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
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID orderId;
    private UUID restaurantId;
    private UUID reservationId;
    private String dish_identifier;
    private String name;
    private Integer quantity;
    private Double price;
    private OrderState state;

    public Order(UUID restaurantId, UUID reservationId, String dish_identifier, String name, Integer quantity, Double price, OrderState state) {
        this.restaurantId = restaurantId;
        this.reservationId = reservationId;
        this.dish_identifier = dish_identifier;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.state = state;
    }
}
