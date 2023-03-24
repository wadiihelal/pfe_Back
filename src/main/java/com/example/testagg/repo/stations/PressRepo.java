package com.example.testagg.repo.stations;

import com.example.testagg.model.stations.Drill;
import com.example.testagg.model.stations.Press;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PressRepo extends MongoRepository<Press,Long> {
    @Aggregation(pipeline = {"{'$match':{'status' : 'SCHEDULED'}}",})
    List<Press> findAllScheduled() ;
    List<Press> findPressByStatus(String status);

}
