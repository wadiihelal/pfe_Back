package com.example.testagg.service.stations;

import com.example.testagg.repo.stations.DrillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrillService {
    @Autowired
    DrillRepo drillRepo;

    public List findAll() {
        return drillRepo.findAll();
    }

    public List findDrillByStatus(String status) {
        return drillRepo.findDrillByStatus(status);
    }
}
