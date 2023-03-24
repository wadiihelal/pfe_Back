package com.example.testagg.controller.stations;

import com.example.testagg.service.stations.HunkelerService;
import com.example.testagg.service.stations.LaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/lamination")
public class LaminationController {
    @Autowired
    LaminationService laminationService;
    @GetMapping
    List findAll() {
        return laminationService.findAll();
    }
}