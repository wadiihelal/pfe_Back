package com.example.testagg.controller.stations;

import com.example.testagg.service.stations.CaseMakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/case-maker")
public class CaseMakerController {
    @Autowired
    CaseMakerService caseMakerService;
    @GetMapping
    List findAll() {
        return caseMakerService.findAll();
    }

    @GetMapping("/quantity-page")
    HashMap findJobQuantity(){
        return caseMakerService.findJobQuantity();
    }
}
