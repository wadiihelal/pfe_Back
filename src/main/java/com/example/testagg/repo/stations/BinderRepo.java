package com.example.testagg.repo.stations;

import com.example.testagg.model.stations.Binder;
import com.example.testagg.model.stations.Drill;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BinderRepo extends MongoRepository<Binder,Integer> {
    List<Drill> findBindersByStatus(String status);

}
