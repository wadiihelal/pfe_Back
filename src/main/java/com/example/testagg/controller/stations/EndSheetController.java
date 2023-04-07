package com.example.testagg.controller.stations;

import com.example.testagg.service.stations.EndSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/end-sheet")
public class EndSheetController {
    @Autowired
    EndSheetService endSheetService;
    @GetMapping
    List findAll() {
        return endSheetService.findAll();
    }

    @GetMapping("/quantity-page")
    HashMap findJobQuantity(){
        return endSheetService.findJobQuantity();
    }
}
