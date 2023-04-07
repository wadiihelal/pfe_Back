package com.example.testagg.repo.stations.bookAssembly;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="BookAssembly") // collection name
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookAssembly {
    @Id
    private Long id;
    private String partid;
    private String priorityLevel;
    private String status;
    private Long idOrder;
    private String orderNum;
    private String bindingType;

}
