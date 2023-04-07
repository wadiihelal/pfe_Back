package com.example.testagg.service.stations;

import com.example.testagg.repo.stations.drill.DrillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class DrillService {
    @Autowired
    DrillRepo drillRepo;

    public List findAll() {
        return drillRepo.findAll();
    }

    public List findDrillByStatus(String status) {
        return drillRepo.findDrillByStatus(status);
    }

    public HashMap findJobWaitingNumber(){
        HashMap tmp = new HashMap<>();
        if(drillRepo.findJobWaitingNumber().size()>0) {
            tmp.put("value", drillRepo.findJobWaitingNumber().get(0));
        }
        else
            tmp.put("value", 0);

        tmp.put("station","Drill");

        return tmp ;
    }
    public HashMap findJobQuantity(){
        HashMap result= new HashMap<>();
        List<Integer> nums=drillRepo.findJobQuantity();
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        result.put("station","Drill");
        result.put("quantity",sum);
        return result;
    }
}
