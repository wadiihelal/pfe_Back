package com.example.testagg.repo.machineRepo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MachineRepo  extends MongoRepository<Machine,Integer> {
}
