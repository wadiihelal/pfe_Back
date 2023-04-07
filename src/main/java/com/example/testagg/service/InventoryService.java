package com.example.testagg.service;

import com.example.testagg.repo.inventory.Inventory;
import com.example.testagg.repo.inventory.InventoryRepo;
import com.example.testagg.service.stations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class InventoryService {
    @Autowired
    InventoryRepo inventoryRepo ;
    @Autowired
    private ApplicationContext applicationContext;

    public List<Inventory> findAll() {
        return inventoryRepo.findAll();
    }
    public HashMap findStationsNumberByStatut (String status) {
        HashMap<String,Integer> map=new HashMap();
        map.put("Binder",applicationContext.getBean(BinderService.class).findBindersByStatus(status).size());
        map.put("BookAssembly",applicationContext.getBean(BookAssemblyService.class).findBookAssembliesByStatus(status).size());
        map.put("Cover",applicationContext.getBean(CoverService.class).findCoverByStatus(status).size());
        map.put("Cutter",applicationContext.getBean(CutterService.class).findCutterByStatus(status).size());
        map.put("DieCutter",applicationContext.getBean(DieCutterService.class).findDieCutterByStatus(status).size());
        map.put("Drill",applicationContext.getBean(DrillService.class).findDrillByStatus(status).size());
        map.put("Horizon",applicationContext.getBean(HorizonService.class).findHorizonByStatus(status).size());
        map.put("Hunkeler",applicationContext.getBean(HunkelerService.class).findHunkelerByStatus(status).size());
        map.put("Lamination",applicationContext.getBean(LaminationService.class).findLaminationByStatus(status).size());
        map.put("Press",applicationContext.getBean(PressService.class).findPressByStatus(status).size());
        map.put("ShrinWrap",applicationContext.getBean(ShrinkWrapService.class).findShrinkWrapByStatus(status).size());
        return map;
    }


    public List findJobWaitingNumber() {
        List output=new ArrayList();
        output.add(applicationContext.getBean(BinderService.class).findJobWaitingNumber());
        output.add(applicationContext.getBean(BookAssemblyService.class).findJobWaitingNumber());
        output.add(applicationContext.getBean(CaseBinderService.class).findJobWaitingNumber());
        output.add(applicationContext.getBean(CaseMakerService.class).findJobWaitingNumber());
        output.add(applicationContext.getBean(CoilPunchService.class).findJobWaitingNumber());
        output.add(applicationContext.getBean(CoverService.class).findJobWaitingNumber());
        output.add(applicationContext.getBean(CutterService.class).findJobWaitingNumber());
        output.add(applicationContext.getBean(DieCutterService.class).findJobWaitingNumber());
        output.add(applicationContext.getBean(DrillService.class).findJobWaitingNumber());
        output.add(applicationContext.getBean(EndSheetService.class).findJobWaitingNumber());
        output.add(applicationContext.getBean(HorizonService.class).findJobWaitingNumber());
        output.add(applicationContext.getBean(HunkelerService.class).findJobWaitingNumber());
        output.add(applicationContext.getBean(LaminationService.class).findJobWaitingNumber());
        output.add(applicationContext.getBean(PressService.class).findJobWaitingNumber());
        output.add(applicationContext.getBean(ShrinkWrapService.class).findJobWaitingNumber());

        return output;
    }

    public List findJobQuantity(){
        List output=new ArrayList();
        output.add(applicationContext.getBean(BinderService.class).findJobQuantity());
        output.add(applicationContext.getBean(BookAssemblyService.class).findJobQuantity());
        output.add(applicationContext.getBean(CaseBinderService.class).findJobQuantity());
        output.add(applicationContext.getBean(CaseMakerService.class).findJobQuantity());
        output.add(applicationContext.getBean(CoilPunchService.class).findJobQuantity());
        output.add(applicationContext.getBean(CoverService.class).findJobQuantity());
        output.add(applicationContext.getBean(CutterService.class).findJobQuantity());
        output.add(applicationContext.getBean(DieCutterService.class).findJobQuantity());
        output.add(applicationContext.getBean(DrillService.class).findJobQuantity());
        output.add(applicationContext.getBean(EndSheetService.class).findJobQuantity());
        output.add(applicationContext.getBean(HorizonService.class).findJobQuantity());
        output.add(applicationContext.getBean(HunkelerService.class).findJobQuantity());
        output.add(applicationContext.getBean(LaminationService.class).findJobQuantity());
        output.add(applicationContext.getBean(PressService.class).findJobQuantity());
        output.add(applicationContext.getBean(ShrinkWrapService.class).findJobQuantity());

        return output;
    }

}
