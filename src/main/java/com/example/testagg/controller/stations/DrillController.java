package com.example.testagg.controller.stations;

import com.example.testagg.service.stations.DrillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/drill")
public class DrillController {
    @Autowired
    DrillService drillService;
    @GetMapping
    List findAll() {
        return drillService.findAll();
    }
    @GetMapping("/{status}")
    public List findDrillByStatus(@PathVariable String status) {
        return drillService.findDrillByStatus(status);
    }
}