package com.example.testagg.service.stations;

import com.example.testagg.repo.stations.CoverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoverService {
    @Autowired
    CoverRepo coverRepo;

    public List findAll() {
        return  coverRepo.findAll();
    }

    public List findCoverByStatus(String status) {
        return coverRepo.findCoverByStatus(status);
    }
}
