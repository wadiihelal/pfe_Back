package com.example.testagg.repo.inventory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryPassedStations {
    private String stationId;
    private Long qtProduced;
}
