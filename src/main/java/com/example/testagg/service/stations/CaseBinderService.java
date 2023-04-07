package com.example.testagg.service.stations;

import com.example.testagg.repo.stations.caseBinder.CaseBinderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CaseBinderService {
    @Autowired
    CaseBinderRepo caseBinderRepo;

    public List findAll() {
        return caseBinderRepo.findAll();
    }
    public HashMap findJobWaitingNumber(){
        HashMap tmp = new HashMap<>();
        if(caseBinderRepo.findJobWaitingNumber().size()>0) {
            tmp.put("value", caseBinderRepo.findJobWaitingNumber().get(0));
        }
        else
            tmp.put("value", 0);

        tmp.put("station","CaseBinder");
        return tmp ;
    }
    public HashMap findJobQuantity(){
        HashMap result= new HashMap<>();
        List<Integer> nums=caseBinderRepo.findJobQuantity();
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        result.put("station","CaseBinder");
        result.put("quantity",sum);
        return result;
    }
}
