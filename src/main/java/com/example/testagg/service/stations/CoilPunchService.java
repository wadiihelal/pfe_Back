package com.example.testagg.service.stations;

import com.example.testagg.repo.stations.coilPunch.CoilPunchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CoilPunchService {
    @Autowired
    CoilPunchRepo coilPunchRepo;

    public List findAll() {
        return coilPunchRepo.findAll();
    }

    public HashMap findJobQuantity(){
        HashMap result= new HashMap<>();
        List<Integer> nums=coilPunchRepo.findJobQuantity();
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        result.put("station","CoilPunch");
        result.put("quantity",sum);
        return result;
    }
    public HashMap findJobWaitingNumber(){
        HashMap tmp = new HashMap<>();
        if(coilPunchRepo.findJobWaitingNumber().size()>0) {
            tmp.put("value", coilPunchRepo.findJobWaitingNumber().get(0));
        }
        else
            tmp.put("value", 0);

        tmp.put("station","CoilPunch");

        return tmp ;
    }
}
