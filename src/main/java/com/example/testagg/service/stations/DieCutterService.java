package com.example.testagg.service.stations;

import com.example.testagg.repo.stations.dieCutter.DieCutterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class DieCutterService {
    @Autowired
    DieCutterRepo dieCutterRepo;

    public List findAll() {
        return dieCutterRepo.findAll();
    }
    public List findDieCutterByStatus(String status) {
        return dieCutterRepo.findDieCutterByStatus(status);
    }
    public HashMap findJobWaitingNumber(){
        HashMap tmp = new HashMap<>();
        if(dieCutterRepo.findJobWaitingNumber().size()>0) {
            tmp.put("value", dieCutterRepo.findJobWaitingNumber().get(0));
        }
        else
            tmp.put("value", 0);

        tmp.put("station","DieCutter");

        return tmp ;
    }
    public HashMap findJobQuantity(){
        HashMap result= new HashMap<>();
        List<Integer> nums=dieCutterRepo.findJobQuantity();
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        result.put("station","DieCutter");
        result.put("quantity",sum);
        return result;
    }
}
