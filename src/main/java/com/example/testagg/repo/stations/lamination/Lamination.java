package com.example.testagg.repo.stations.lamination;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Lamination") // collection name
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lamination {
    @Id
    private String id;
    private String partid;
    private String priorityLevel;
    private String status;
    private Long idOrder;
    private String orderNum;
    private String bindingType;

}
