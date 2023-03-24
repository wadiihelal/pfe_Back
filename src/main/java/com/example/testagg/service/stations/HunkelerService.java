package com.example.testagg.service.stations;

import com.example.testagg.repo.stations.HunkelerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HunkelerService {
    @Autowired
    HunkelerRepo hunkelerRepo;

    public List findAll() {
       return hunkelerRepo.findAll();
    }
    public List findHunkelerByStatus(String status) {
        return hunkelerRepo.findHunkelerByStatus(status);
    }
}
