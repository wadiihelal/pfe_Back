package com.example.testagg.repo.machineRepo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Document(collection="machineetstation") // collection name
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Machine {
    @Id
    private String id;
    private String name;
    private String status;
    private HashMap typemachine;
    private  Long speed;
}
