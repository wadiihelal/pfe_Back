package com.example.testagg.repo.stations;

import com.example.testagg.model.stations.Drill;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DrillRepo  extends MongoRepository <Drill,Integer> {
     List<Drill> findDrillByStatus(String status);
}
