package com.example.testagg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection="orders") // collection name
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id

    private Long orderid;
    private Instant dateExpacted;
    private String status;
    private String clientId;
    private OrderProductionParts[] productionParts;

}
