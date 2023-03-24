package com.example.testagg.controller.stations;

import com.example.testagg.service.stations.DieCutterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/diecutter")
public class DieCutterController {
    @Autowired
    DieCutterService dieCutterService;
    @GetMapping
    List findAll() {
        return dieCutterService.findAll();
    }
}