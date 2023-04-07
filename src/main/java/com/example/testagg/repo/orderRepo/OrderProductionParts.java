package com.example.testagg.repo.orderRepo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductionParts {

    private Long colors;
    private Long qtyRequested;
    private double hours;
    private double length;
}
