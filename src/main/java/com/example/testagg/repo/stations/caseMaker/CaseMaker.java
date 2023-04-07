package com.example.testagg.repo.stations.caseMaker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="CaseMaker") // collection name
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CaseMaker {
    @Id
    private Long id;
    private String status;
    private String machineId;
    private String priorityLevel;
    private String partid;
    private Long idOrder;
    private Long colors;
    private String bindingType;

}
