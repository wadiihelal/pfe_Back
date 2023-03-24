package com.example.testagg.repo.stations;

import com.example.testagg.model.stations.Drill;
import com.example.testagg.model.stations.ShrinkWrap;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ShrinkWrapRepo extends MongoRepository<ShrinkWrap,Integer>
{
    List<ShrinkWrap> findShrinkWrapByStatus(String status);

}
