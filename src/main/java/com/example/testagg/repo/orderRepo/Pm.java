package com.example.testagg.repo.orderRepo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.HashMap;

@Document
@Data

public class Pm {
    @Field("_id")
    @Id
    public HashMap id;
    public long[] length;
}
