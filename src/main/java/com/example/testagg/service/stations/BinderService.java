package com.example.testagg.service.stations;

import com.example.testagg.repo.stations.binder.BinderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BinderService {
    @Autowired
    BinderRepo binderRepo;

    public List findAll() {
        return binderRepo.findAll();
    }
    public List findBindersByStatus(String status) {
        return binderRepo.findBindersByStatus(status);
    }

    public HashMap findJobQuantity(){
        HashMap result= new HashMap<>();
        List<Integer> nums=binderRepo.findJobQuantity();
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        result.put("station","Binder");
        result.put("quantity",sum);
        return result;
    }
    public HashMap findJobWaitingNumber(){
        HashMap tmp = new HashMap<>();
        if(binderRepo.findJobWaitingNumber().size()>0) {
            tmp.put("value", binderRepo.findJobWaitingNumber().get(0));
        }
        else
            tmp.put("value", 0);

        tmp.put("station","Binder");
        return tmp ;
    }
}
