package com.example.testagg.service.stations;

import com.example.testagg.repo.stations.PressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PressService {
    @Autowired
    private PressRepo pressRepo;

    public List findAllScheduled() {
    return pressRepo.findAllScheduled();
    }

    public List findPressByStatus(String status) {
        return pressRepo.findPressByStatus(status);
    }
}
