package com.example.testagg.controller.stations;

import com.example.testagg.service.stations.PressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/press")
public class PressController {

    @Autowired
    PressService service;
    @GetMapping("/scheduled")
    List findAllScheduled(){
        return service.findAllScheduled();
    }
}
