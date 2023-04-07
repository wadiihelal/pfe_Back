package com.example.testagg.controller.stations;

import com.example.testagg.service.stations.BinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/binder")
public class BinderController {
    @Autowired
    BinderService binderService;
    @GetMapping
    List findAll() {
        return binderService.findAll();
    }

    @GetMapping("/quantity-page")
    HashMap findJobQuantity(){
        return binderService.findJobQuantity();
    }
}
