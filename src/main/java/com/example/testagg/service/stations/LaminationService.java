package com.example.testagg.service.stations;

import com.example.testagg.repo.stations.lamination.LaminationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class LaminationService {
    @Autowired
    LaminationRepo laminationRepo;

    public List findAll() {
        return laminationRepo.findAll();
    }
    public List findLaminationByStatus(String status) {
        return laminationRepo.findLaminationByStatus(status);
    }

    public HashMap findJobWaitingNumber(){
        HashMap tmp = new HashMap<>();
        if(laminationRepo.findJobWaitingNumber().size()>0) {
            tmp.put("value", laminationRepo.findJobWaitingNumber().get(0));
        }
        else
            tmp.put("value", 0);
        tmp.put("station","Lamination");
        return tmp ;
    }
    public HashMap findJobQuantity(){
        HashMap result= new HashMap<>();
        List<Integer> nums=laminationRepo.findJobQuantity();
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        result.put("station","Lamination");
        result.put("quantity",sum);
        return result;
    }
}
