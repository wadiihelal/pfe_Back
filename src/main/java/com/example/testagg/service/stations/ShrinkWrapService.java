package com.example.testagg.service.stations;

import com.example.testagg.repo.stations.shrinkWrap.ShrinkWrapRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ShrinkWrapService {
    @Autowired
    ShrinkWrapRepo shrinkWrapRepo;

    public List findAll() {
        return shrinkWrapRepo.findAll();
    }

    public List findShrinkWrapByStatus(String status) {
        return shrinkWrapRepo.findShrinkWrapByStatus(status);
    }
    public HashMap findJobQuantity(){
        HashMap result= new HashMap<>();
        List<Integer> nums=shrinkWrapRepo.findJobQuantity();
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        result.put("station","ShrinkWrap");
        result.put("quantity",sum);
        return result;
    }
    public HashMap findJobWaitingNumber(){
        HashMap tmp = new HashMap<>();
        if(shrinkWrapRepo.findJobWaitingNumber().size()>0) {
            tmp.put("value", shrinkWrapRepo.findJobWaitingNumber().get(0));
            tmp.put("station","ShrinkWrap");
        }
        else {
            tmp.put("value", 0);
            tmp.put("station","ShrinkWrap");
        }
        return tmp ;
    }
}
