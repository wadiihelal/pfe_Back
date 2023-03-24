package com.example.testagg.model.stations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Hunkeler") // collection name
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hunkeler {
    @Id
    private String id;
    private String partid;
    private String priorityLevel;
    private String status;
    private Long idOrder;
    private String orderNum;
    private String bindingType;

}
