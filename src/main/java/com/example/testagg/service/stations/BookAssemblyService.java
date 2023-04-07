package com.example.testagg.service.stations;

import com.example.testagg.repo.stations.bookAssembly.BookAssemblyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BookAssemblyService
{
    @Autowired
    BookAssemblyRepo bookAssemblyRepo;

    public List findAll() {
        return bookAssemblyRepo.findAll();
    }
    public List findBookAssembliesByStatus(String status) {
        return bookAssemblyRepo.findBookAssembliesByStatus(status);
    }
    public HashMap findJobWaitingNumber(){
        HashMap tmp = new HashMap<>();
        if(bookAssemblyRepo.findJobWaitingNumber().size()>0) {
            tmp.put("value", bookAssemblyRepo.findJobWaitingNumber().get(0));
        }
        else
            tmp.put("value", 0);

        tmp.put("station","BookAssembly");

        return tmp ;
    }
    public HashMap findJobQuantity(){
        HashMap result= new HashMap<>();
        List<Integer> nums=bookAssemblyRepo.findJobQuantity();
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        result.put("station","BookAssembly");
        result.put("quantity",sum);
        return result;
    }
}
