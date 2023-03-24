package com.example.testagg.repo.stations;

import com.example.testagg.model.stations.Cutter;
import com.example.testagg.model.stations.Drill;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CutterRepo extends MongoRepository<Cutter,Integer> {
    List<Cutter> findCutterByStatus(String status);

}
