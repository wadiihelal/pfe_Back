package com.example.testagg.repo.orderRepo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@Document(collection="order") // collection name
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersProduction {

    private Date     date;
    private ArrayList <HashMap> info;
}