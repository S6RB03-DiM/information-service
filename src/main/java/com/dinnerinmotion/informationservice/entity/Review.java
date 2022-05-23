package com.dinnerinmotion.informationservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

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
    private UUID reviewId;
    private UUID restaurant_id;
    private UUID customer_id;
    private Double rating;
    private String description;
}
