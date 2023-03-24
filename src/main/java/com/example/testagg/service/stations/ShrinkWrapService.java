package com.example.testagg.service.stations;

import com.example.testagg.repo.stations.ShrinkWrapRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShrinkWrapService {
    @Autowired
    ShrinkWrapRepo shrinkWrapRepo;

    public List findAll() {
        return shrinkWrapRepo.findAll();
    }

    public List findShrinkWrapByStatus(String status) {
        return shrinkWrapRepo.findShrinkWrapByStatus(status);
    }
}
