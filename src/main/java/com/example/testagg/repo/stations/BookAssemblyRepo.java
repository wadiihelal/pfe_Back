package com.example.testagg.repo.stations;

import com.example.testagg.model.stations.BookAssembly;
import com.example.testagg.model.stations.Drill;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookAssemblyRepo extends MongoRepository<BookAssembly,Integer> {
    List<BookAssembly> findBookAssembliesByStatus(String status);

}
