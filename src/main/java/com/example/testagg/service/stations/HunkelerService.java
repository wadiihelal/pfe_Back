package com.example.testagg.service.stations;

import com.example.testagg.repo.stations.hunkeler.HunkelerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class HunkelerService {
    @Autowired
    HunkelerRepo hunkelerRepo;

    public List findAll() {
       return hunkelerRepo.findAll();
    }
    public List findHunkelerByStatus(String status) {
        return hunkelerRepo.findHunkelerByStatus(status);
    }

    public HashMap findJobWaitingNumber(){
        HashMap tmp = new HashMap<>();
        if(hunkelerRepo.findJobWaitingNumber().size()>0) {
            tmp.put("value", hunkelerRepo.findJobWaitingNumber().get(0));
        }
        else
            tmp.put("value", 0);

        tmp.put("station","Hunkeler");
        return tmp ;
    }
    public HashMap findJobQuantity(){
        HashMap result= new HashMap<>();
        List<Integer> nums=hunkelerRepo.findJobQuantity();
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        result.put("station","Hunkeler");
        result.put("quantity",sum);
        return result;
    }
}
