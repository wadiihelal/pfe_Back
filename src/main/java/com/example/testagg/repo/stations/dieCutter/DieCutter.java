package com.example.testagg.repo.stations.dieCutter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="DieCutter") // collection name
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DieCutter {
    @Id
    private String id;
    private String status;
    private String priorityLevel;
    private String partid;
    private Long idOrder;
    private String bindingType;

}