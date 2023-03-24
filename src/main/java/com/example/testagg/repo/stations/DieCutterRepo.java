package com.example.testagg.repo.stations;

import com.example.testagg.model.stations.DieCutter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DieCutterRepo extends MongoRepository<DieCutter,Integer> {
    List <DieCutter> findDieCutterByStatus(String status);
}
