package com.example.testagg.service.stations;

import com.example.testagg.repo.stations.horizon.HorizonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
    public HashMap findJobWaitingNumber(){
        HashMap tmp = new HashMap<>();
        if(horizonRepo.findJobWaitingNumber().size()>0) {
            tmp.put("value", horizonRepo.findJobWaitingNumber().get(0));
        }
        else
            tmp.put("value", 0);

        tmp.put("station","Horizon");
        return tmp ;
    }
    public HashMap findJobQuantity(){
        HashMap result= new HashMap<>();
        List<Integer> nums=horizonRepo.findJobQuantity();
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        result.put("station","Horizon");
        result.put("quantity",sum);
        return result;
    }
}
