package com.example.testagg.controller.stations;

import com.example.testagg.service.stations.CoilPunchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/coil-punch")
public class CoilPunchController {
    @Autowired
    CoilPunchService coilPunchService;
    @GetMapping
    List findAll() {
        return coilPunchService.findAll();
    }

    @GetMapping("/quantity-page")
    HashMap findJobQuantity(){
        return coilPunchService.findJobQuantity();
    }
}
