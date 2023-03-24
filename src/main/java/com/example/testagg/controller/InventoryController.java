package com.example.testagg.controller;

import com.example.testagg.model.Inventory;
import com.example.testagg.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    InventoryService inventoryService;
    @GetMapping
    List<Inventory> findAll() {
        return inventoryService.findAll();
    }
    @GetMapping("/{status}")
    public HashMap DrillController(@PathVariable String status) {
        return inventoryService.findStationsNumberByStatut(status.toUpperCase());
    }
}
