package com.example.testagg.service.stations;

import com.example.testagg.repo.stations.DieCutterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DieCutterService {
    @Autowired
    DieCutterRepo dieCutterRepo;

    public List findAll() {
        return dieCutterRepo.findAll();
    }
    public List findDieCutterByStatus(String status) {
        return dieCutterRepo.findDieCutterByStatus(status);
    }
}
