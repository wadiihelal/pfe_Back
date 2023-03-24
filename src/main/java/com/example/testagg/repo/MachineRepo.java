package com.example.testagg.repo;

import com.example.testagg.model.Machine;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MachineRepo  extends MongoRepository<Machine,Integer> {
}
