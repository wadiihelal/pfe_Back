package com.example.testagg.repo.stations;

import com.example.testagg.model.stations.Drill;
import com.example.testagg.model.stations.Lamination;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LaminationRepo extends MongoRepository<Lamination,Integer> {
    List<Lamination> findLaminationByStatus(String status);

}
