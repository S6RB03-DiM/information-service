package com.dinnerinmotion.informationservice.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name = "reservations")
public class Reservation {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    @JsonProperty("id")
    private UUID id;
    @JsonProperty("restaurant_id")
    private UUID restaurant_id;
    @JsonProperty("customer_id")
    private UUID customer_id;
    @JsonProperty("groupSize")
    private Integer groupSize;
    @JsonProperty("customers")
    @JsonAlias({"group"})
    private String customers;
    @JsonProperty("tableNumber")
    private String tableNumber;
    @JsonProperty("created_at")
    private String created_at;
    @JsonProperty("state")
    private Integer state;
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("single_household")
    private Boolean single_household;
}