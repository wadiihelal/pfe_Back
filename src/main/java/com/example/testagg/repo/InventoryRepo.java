package com.example.testagg.repo;

import com.example.testagg.model.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InventoryRepo  extends MongoRepository<Inventory,Integer> {
}
