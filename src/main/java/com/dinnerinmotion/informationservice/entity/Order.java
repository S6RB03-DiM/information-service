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
    @Column(columnDefinition = "BINARY(16)")
    private UUID orderId;
    private UUID restaurantId;
    private UUID reservationId;
    private String dish_identifier;
    private String name;
    private Integer quantity;
    private Double price;
    private OrderState state;
}
