package com.example.testagg.service.stations;

import com.example.testagg.repo.stations.HorizonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorizonService {
    @Autowired
    HorizonRepo horizonRepo;

    public List findAll() {
        return horizonRepo.findAll();
    }
    public List findHorizonByStatus(String status) {
        return horizonRepo.findHorizonByStatus(status);
    }
}
