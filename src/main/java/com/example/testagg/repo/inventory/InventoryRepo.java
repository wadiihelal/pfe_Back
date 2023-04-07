package com.example.testagg.repo.inventory;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface InventoryRepo  extends MongoRepository<Inventory,Integer> {
}
