package com.example.testagg.service.stations;

import com.example.testagg.repo.stations.LaminationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaminationService {
    @Autowired
    LaminationRepo laminationRepo;

    public List findAll() {
        return laminationRepo.findAll();
    }
    public List findLaminationByStatus(String status) {
        return laminationRepo.findLaminationByStatus(status);
    }
}
