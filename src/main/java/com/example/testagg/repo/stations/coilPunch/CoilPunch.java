package com.example.testagg.repo.stations.coilPunch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="CoilPunch") // collection name
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoilPunch {
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
