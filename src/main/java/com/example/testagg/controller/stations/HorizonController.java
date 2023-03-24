package com.example.testagg.controller.stations;

import com.example.testagg.service.stations.HorizonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/horizon")
public class HorizonController {
    @Autowired
    HorizonService horizonService;
    @GetMapping
    List findAll() {
        return horizonService.findAll();
    }
}