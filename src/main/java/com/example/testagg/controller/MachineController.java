package com.example.testagg.controller;

import com.example.testagg.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/machine")
public class MachineController {
    @Autowired
    MachineService machineService;
    @GetMapping
    List findAll() {
        return machineService.findAll();
    }
}