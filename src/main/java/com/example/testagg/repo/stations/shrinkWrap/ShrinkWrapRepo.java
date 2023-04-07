package com.example.testagg.repo.stations.shrinkWrap;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ShrinkWrapRepo extends MongoRepository<ShrinkWrap,Integer>
{
    List<ShrinkWrap> findShrinkWrapByStatus(String status);
    @Aggregation(pipeline = {
            "{ '$match': { 'status': { '$in': [ 'ON PROD', 'SCHEDULED', 'ASSIGNED' ] } } }",
            "{ '$group': { '_id': { 'clientId': '$clientId' }, 'totalAmount': { '$sum': 1 } } }",
            "{ '$project': { '_id': 0 } }"
    })
    List findJobWaitingNumber();
    @Aggregation(pipeline = {
            " { '$match': { 'status': { '$in': [ 'ON PROD', 'SCHEDULED', 'ASSIGNED' ] } } }",
            "{ '$project': { 'adjustedGrades': { '$map': { 'input': '$productionPartInfos', 'as': 'grade', 'in': { '$add': [ { '$multiply': [ '$$grade.productionPage', '$$grade.qtyRequested' ] } ] } } } } }",
            "{ '$project': { 'prod': { '$sum': '$adjustedGrades' } } }",
            "{ '$project': { '_id': 0 } }"
    })
    List findJobQuantity();

}
