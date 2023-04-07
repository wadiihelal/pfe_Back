package com.example.testagg.service.stations;

import com.example.testagg.repo.stations.cutter.CutterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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

    public HashMap findJobWaitingNumber(){
        HashMap tmp = new HashMap<>();
        if(cutterRepo.findJobWaitingNumber().size()>0) {
            tmp.put("value", cutterRepo.findJobWaitingNumber().get(0));
        }
        else
            tmp.put("value", 0);

        tmp.put("station","Cutter");

        return tmp ;
    }
    public HashMap findJobQuantity(){
        HashMap result= new HashMap<>();
        List<Integer> nums=cutterRepo.findJobQuantity();
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        result.put("station","Cutter");
        result.put("quantity",sum);
        return result;
    }
}
