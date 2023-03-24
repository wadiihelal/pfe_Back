package com.example.testagg.service;

import com.example.testagg.model.Inventory;
import com.example.testagg.repo.InventoryRepo;
import com.example.testagg.service.stations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

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

}
