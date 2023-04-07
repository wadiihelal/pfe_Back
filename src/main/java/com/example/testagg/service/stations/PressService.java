package com.example.testagg.service.stations;

import com.example.testagg.repo.stations.press.PressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class PressService {
    @Autowired
    private PressRepo pressRepo;

    public List findAllScheduled() {
    return pressRepo.findAllScheduled();
    }

    public List findPressByStatus(String status) {
        return pressRepo.findPressByStatus(status);
    }


    public HashMap findJobQuantity(){
        HashMap result= new HashMap<>();
        List<Integer> nums=pressRepo.findJobQuantity();
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        result.put("station","Press");
        result.put("quantity",sum);
        return result;
    }
    public HashMap findJobWaitingNumber(){
        HashMap tmp = new HashMap<>();
        if(pressRepo.findJobWaitingNumber().size()>0) {
            tmp.put("value", pressRepo.findJobWaitingNumber().get(0));
        }
        else
            tmp.put("value", 0);

        tmp.put("station","Press");
        return tmp ;}

    public  List <HashMap> findWorkPlanifiedByPageAndStation(){
        return pressRepo.findWorkPlanifiedByPageAndStation();
    }
    public  List <HashMap> findWorkPlanifiedByPageAndPaperType(){
        return pressRepo.findWorkPlanifiedByPageAndPaperType();
    }
    public  List <HashMap> findWorkPlanifiedByPageAndClient(){
        return pressRepo.findWorkPlanifiedByPageAndClient();
    }
    public  List <HashMap> findWorkPlanifiedByPageAndColor(){
        return pressRepo.findWorkPlanifiedByPageAndColor();
    }
    public  List <HashMap> findJobReportBy1Colors(){
        return pressRepo.findJobReportBy1Colors();
    }
    public  List <HashMap> findJobReportBy4Colors(){
        return pressRepo.findJobReportBy4Colors();
    }
}
