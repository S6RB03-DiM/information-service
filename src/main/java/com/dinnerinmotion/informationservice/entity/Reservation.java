package com.dinnerinmotion.informationservice.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;
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
    private String customers; //is array
    @JsonProperty("tableNumber")
    private String tableNumber;
    @JsonProperty("created_at")
    private String created_at; // is datetime
    @JsonProperty("state")
    private Integer state; //is array
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("single_household")
    private Boolean single_household;
}

/*EXAMPLE
{
 "id":"d87e8c33-30ea-4a94-95e7-f3ea02ce6672",
 "restaurant_id":"31481616-3d3d-4fc3-b64a-2ac58bd8c44e",
 "customer_id":"683211de-a410-4431-ab1a-2608eeb7b97e",
 "customers":[{"customer_id":"group3MockCustomer1"},
          {"customer_id":"group3MockCustomer2"},
          {"customer_id":"group3MockCustomer3"}],
 "groupSize":3,
 "tableNumber":"1",
 "created_at":"2022-05-23T14:14:58.1430073+00:00",
 "state":0,
 "comment":"",
 "single_household":false
}
*/