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
@Table(name = "reviews")
public class Review {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    @JsonProperty("id")
    private UUID id;
    @JsonProperty("restaurant_id")
    private UUID restaurant_id;
    @JsonProperty("customer_id")
    private UUID customer_id;
    @JsonProperty("rating")
    private Double rating;
    @JsonProperty("description")
    private String description;
}
