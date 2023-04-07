package com.example.testagg.service.stations;

import com.example.testagg.repo.stations.assembly.AssemblyRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class AssemblyService {
    @Autowired
    AssemblyRepo assemblyRepo;
    public HashMap findJobQuantity(){
        HashMap result= new HashMap<>();
        List<Integer> nums=assemblyRepo.findJobQuantity();
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        result.put("station","Assembly");
        result.put("quantity",sum);
        return result;
    }
}
