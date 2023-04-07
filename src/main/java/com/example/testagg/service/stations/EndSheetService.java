package com.example.testagg.service.stations;

import com.example.testagg.repo.stations.endSheet.EndSheetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class EndSheetService {
    @Autowired
    EndSheetRepo endSheetRepo;

    public List findAll() {
        return endSheetRepo.findAll();
    }

    public HashMap findJobQuantity(){
        HashMap result= new HashMap<>();
        List<Integer> nums=endSheetRepo.findJobQuantity();
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        result.put("station","EndSheet");
        result.put("quantity",sum);
        return result;
    }
    public HashMap findJobWaitingNumber(){
        HashMap tmp = new HashMap<>();
        if(endSheetRepo.findJobWaitingNumber().size()>0) {
            tmp.put("value", endSheetRepo.findJobWaitingNumber().get(0));
        }
        else
            tmp.put("value", 0);

        tmp.put("station","EndSheet");
        return tmp ;
    }
}
