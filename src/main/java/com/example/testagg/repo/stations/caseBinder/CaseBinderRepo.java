package com.example.testagg.repo.stations.caseBinder;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface CaseBinderRepo extends MongoRepository<CaseBinder,Integer> {
    @Aggregation(pipeline = {
            "{ '$match': { 'status': { '$in': [ 'ON PROD', 'SCHEDULED', 'ASSIGNED' ] } } }",
            "{ '$project': { 'total': { '$multiply': [ '$qtyMin', '$productionPage' ] } } }",
            "{ '$project': { 'prod': { '$sum': '$total' } } }",
            "{ '$project': { '_id': 0 } }"
    })
    List findJobQuantity();
    @Aggregation(pipeline = {
            "{ '$match': { 'status': { '$in': [ 'ON PROD', 'SCHEDULED', 'ASSIGNED' ] } } }",
            "{ '$group': { '_id': { 'clientId': '$clientId' }, 'totalAmount': { '$sum': 1 } } }",
            "{ '$project': { '_id': 0 } }"
    })
    List findJobWaitingNumber();
}
