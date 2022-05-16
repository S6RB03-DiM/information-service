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
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID reservationId;
    private UUID restaurant_id;
    private UUID customer_id;
    private Integer groupSize;
    private Integer customers; //is array
    private String tableNumber;
    private String created_at; // is datetime
    private String state; //is array
    private String comment;
    private Boolean single_household;


}
