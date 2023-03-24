package com.example.testagg.service.stations;

import com.example.testagg.repo.stations.CutterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CutterService {
    @Autowired
    CutterRepo cutterRepo;

    public List findAll(){
        return cutterRepo.findAll();
    }
    public List findCutterByStatus(String status) {
        return cutterRepo.findCutterByStatus(status);
    }
}
