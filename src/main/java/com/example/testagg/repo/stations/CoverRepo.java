package com.example.testagg.repo.stations;

import com.example.testagg.model.stations.Cover;
import com.example.testagg.model.stations.Drill;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CoverRepo  extends MongoRepository <Cover,Integer> {
    List<Cover> findCoverByStatus(String status);

}
