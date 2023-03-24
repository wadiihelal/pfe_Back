package com.example.testagg.repo.stations;

import com.example.testagg.model.stations.Drill;
import com.example.testagg.model.stations.Horizon;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HorizonRepo extends MongoRepository<Horizon,Integer> {
    List<Horizon> findHorizonByStatus(String status);

}
