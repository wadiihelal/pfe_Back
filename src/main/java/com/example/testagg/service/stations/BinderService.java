package com.example.testagg.service.stations;

import com.example.testagg.repo.stations.BinderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BinderService {
    @Autowired
    BinderRepo binderRepo;

    public List findAll() {
        return binderRepo.findAll();
    }
    public List findBindersByStatus(String status) {
        return binderRepo.findBindersByStatus(status);
    }
}
