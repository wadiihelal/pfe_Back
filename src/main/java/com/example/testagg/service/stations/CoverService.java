package com.example.testagg.service.stations;

import com.example.testagg.repo.stations.cover.CoverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CoverService {
    @Autowired
    CoverRepo coverRepo;

    public List findAll() {
        return  coverRepo.findAll();
    }

    public List findCoverByStatus(String status) {
        return coverRepo.findCoverByStatus(status);
    }

    public HashMap findJobWaitingNumber(){
        HashMap tmp = new HashMap<>();
        if(coverRepo.findJobWaitingNumber().size()>0) {
            tmp.put("value", coverRepo.findJobWaitingNumber().get(0));
            tmp.put("station","Cover");
        }
        else {
            tmp.put("value", 0);
            tmp.put("station","Cover");
        }

        return tmp ;
    }
    public HashMap findJobQuantity(){
        HashMap result= new HashMap<>();
        List<Integer> nums=coverRepo.findJobQuantity();
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        result.put("station","Cover");
        result.put("quantity",sum);
        return result;
    }
}
