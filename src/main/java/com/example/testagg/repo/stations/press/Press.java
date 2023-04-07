package com.example.testagg.repo.stations.press;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Press")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Press {
    @Id
    private Long id;

    private String priorityLevel;
    private  String status;
    private PressProductionParts[] productionPartInfos;
}

