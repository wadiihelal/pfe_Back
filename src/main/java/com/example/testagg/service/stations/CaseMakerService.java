package com.example.testagg.service.stations;

import com.example.testagg.repo.stations.caseMaker.CaseMakerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CaseMakerService {
    @Autowired
    CaseMakerRepo caseMakerRepo;

    public List findAll() {
        return caseMakerRepo.findAll();
    }

    public HashMap findJobQuantity(){
        HashMap result= new HashMap<>();
        List<Integer> nums=caseMakerRepo.findJobQuantity();
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        result.put("station","CaseMaker");
        result.put("quantity",sum);
        return result;
    }
    public HashMap findJobWaitingNumber(){
        HashMap tmp = new HashMap<>();
        if(caseMakerRepo.findJobWaitingNumber().size()>0) {
            tmp.put("value", caseMakerRepo.findJobWaitingNumber().get(0));
        }
        else
            tmp.put("value", 0);

        tmp.put("station","CaseMaker");

        return tmp ;
    }
}
