package com.example.testagg.controller.stations;

import com.example.testagg.service.stations.CoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/cover")
public class CoverController {

    @Autowired
    CoverService coverService;

    @GetMapping
    public List findAll() {
        return coverService.findAll();
    }

}
