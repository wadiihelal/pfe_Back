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



    @GetMapping("/planified-page")
    List findWorkPlanifiedByPageAndStation(){ return service.findWorkPlanifiedByPageAndStation();}
    @GetMapping("/planified-page-paper-type")
    List findWorkPlanifiedByPageAndPaperType(){ return service.findWorkPlanifiedByPageAndPaperType();}
    @GetMapping("/planified-page-client")
    List findWorkPlanifiedByPageAndClient(){ return service.findWorkPlanifiedByPageAndClient();}
    @GetMapping("/planified-page-color")
    List findWorkPlanifiedByPageAndColor(){ return service.findWorkPlanifiedByPageAndColor();}
    @GetMapping("/report-1")
    List findJobReportBy1Colors(){ return service.findJobReportBy1Colors();}
    @GetMapping("/report-4")
    List findJobReportBy4Colors(){ return service.findJobReportBy4Colors();}
}
