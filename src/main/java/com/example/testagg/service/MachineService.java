package com.example.testagg.service;

import com.example.testagg.repo.machineRepo.MachineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineService {
    @Autowired
    MachineRepo machineRepo;

    public List findAll() {

        return machineRepo.findAll();
    }
}
