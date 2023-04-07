package com.example.testagg.controller.stations;

import com.example.testagg.service.stations.CaseBinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/case-binder")
public class CaseBinderController {
    @Autowired
    CaseBinderService caseBinderService;
    @GetMapping
    List findAll() {
        return caseBinderService.findAll();
    }

    @GetMapping("/quantity-page")
    HashMap findJobQuantity(){
        return caseBinderService.findJobQuantity();
    }
}
