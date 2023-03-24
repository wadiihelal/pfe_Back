package com.example.testagg.repo.stations;

import com.example.testagg.model.stations.Drill;
import com.example.testagg.model.stations.Hunkeler;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HunkelerRepo  extends MongoRepository<Hunkeler,Integer> {
    List<Hunkeler> findHunkelerByStatus(String status);

}
