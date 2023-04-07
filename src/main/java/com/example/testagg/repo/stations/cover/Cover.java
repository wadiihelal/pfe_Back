package com.example.testagg.repo.stations.cover;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Cover") // collection name
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cover {
    @Id
    private String id;
    private String status;
    private String priorityLevel;
    private String partid;
    private Long idOrder;
    private Long colors;
    private String bindingType;

}
