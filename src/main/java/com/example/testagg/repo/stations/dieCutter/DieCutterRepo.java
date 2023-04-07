package com.example.testagg.repo.stations.dieCutter;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DieCutterRepo extends MongoRepository<DieCutter,Integer> {
    List <DieCutter> findDieCutterByStatus(String status);
    @Aggregation(pipeline = {
            "{ '$match': { 'status': { '$in': [ 'ON PROD', 'SCHEDULED', 'ASSIGNED' ] } } }",
            "{ '$group': { '_id': { 'clientId': '$clientId' }, 'totalAmount': { '$sum': 1 } } }",
            "{ '$project': { '_id': 0 } }"
    })
    List findJobWaitingNumber();
    @Aggregation( pipeline = {
            "{ '$match': { 'status': { '$in': [ 'ON PROD', 'SCHEDULED', 'ASSIGNED' ] } } }",
            "{ '$lookup': { 'from': 'parts', 'localField': 'partid', 'foreignField': '_id', 'as': 'info' } }",
            "{ '$group': { '_id': '$_id', 'page': { '$first': '$info.productionPage' }, 'qtyRequested': { '$first': '$qtyRequested' } } }",
            "{ '$unwind': '$page' }",
            "{ '$project': { '_id': 0, 'total': { '$multiply': [ '$page', '$qtyRequested' ] } } },"
    })
    List findJobQuantity();
}
