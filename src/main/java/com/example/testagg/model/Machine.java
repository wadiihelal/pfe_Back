package com.example.testagg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="machineetstation") // collection name
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Machine {
    @Id
    private String id;
    private String name;
    private String status;
}
