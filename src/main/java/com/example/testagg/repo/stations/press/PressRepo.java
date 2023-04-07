package com.example.testagg.repo.stations.press;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.HashMap;
import java.util.List;

public interface PressRepo extends MongoRepository<Press,Long> {
    @Aggregation(pipeline = {"{'$match':{'status' : 'SCHEDULED'}}",})
    List<Press> findAllScheduled() ;
    List<Press> findPressByStatus(String status);

    @Aggregation(pipeline = {
            " { '$match': { 'status': { '$in': [ 'ON PROD', 'SCHEDULED', 'ASSIGNED' ] } } }",
            "{ '$project': { 'adjustedGrades': { '$map': { 'input': '$productionPartInfos', 'as': 'grade', 'in': { '$add': [ { '$multiply': [ '$$grade.productionPage', '$$grade.qtyRequested' ] } ] } } } } }",
            "{ '$project': { 'prod': { '$sum': '$adjustedGrades' } } }",
            "{ '$project': { '_id': 0 } }"
    })
    List findJobQuantity();


    @Aggregation(pipeline = {
            "{ '$match': { 'status': { '$in': [ 'ON PROD', 'SCHEDULED', 'ASSIGNED' ] } } }",
            "{ '$group': { '_id': { 'clientId': '$clientId' }, 'totalAmount': { '$sum': 1 } } }",
            "{ '$project': { '_id': 0 } }"
            })
    List findJobWaitingNumber();

    @Aggregation(pipeline = {
            "{ '$match': { 'status': { '$in': [ 'ON PROD', 'SCHEDULED', 'ASSIGNED' ] } } }",
            "{ '$project': { 'paperTypeId': 1, 'machineType': 1, 'prodPages': { '$map': { 'input': '$productionPartInfos', 'as': 'grade', 'in': { '$add': [ { '$multiply': [ '$$grade.productionPage', '$$grade.qtyRequested' ] } ] } } } } }",
            "{ '$group': { '_id': '$machineType', 'prodPages': { '$push': '$prodPages' } } }",
            "{ '$project': { 'prodPages': { '$reduce': { 'input': '$prodPages', 'initialValue': [], 'in': { '$concatArrays': [ '$$value', '$$this' ] } } } } }",
            "{ '$project': { 'total': { '$sum': [ '$prodPages' ] } } } ",
            "{'$project': {'machine': '$_id', '_id': 0,'total': 1}}"

    })
    List<HashMap> findWorkPlanifiedByPageAndStation();
    @Aggregation(pipeline = {
            "{ '$match': { 'status': { '$in': [ 'ON PROD', 'SCHEDULED', 'ASSIGNED' ] } } }",
            "{ '$project': { 'paperTypeId': 1, 'machineType': 1, 'prodPages': { '$map': { 'input': '$productionPartInfos', 'as': 'grade', 'in': { '$add': [ { '$multiply': [ '$$grade.productionPage', '$$grade.qtyRequested' ] } ] } } } } }",
            "{ '$group': { '_id': '$paperTypeId', 'prodPages': { '$push': '$prodPages' } } }",
            "{ '$project': { 'prodPages': { '$reduce': { 'input': '$prodPages', 'initialValue': [], 'in': { '$concatArrays': [ '$$value', '$$this' ] } } } } }",
            "{ '$project': { 'total': { '$sum': [ '$prodPages' ] } } } ",
            "{'$project': {'type': '$_id', '_id': 0,'total': 1}}"

    })
    List<HashMap> findWorkPlanifiedByPageAndPaperType();


    @Aggregation(pipeline = {
            "{ '$match': { 'status': { '$in': [ 'ON PROD', 'SCHEDULED', 'ASSIGNED' ] } } }",
            "{ '$project': { 'productionPartInfos.publisherId': 1, 'qty': { '$map': { 'input': '$productionPartInfos', 'as': 'grade', 'in': { '$add': [ { '$multiply': [ '$$grade.productionPage', '$$grade.qtyRequested' ] } ] } } } } }",
            "{ '$unwind': '$productionPartInfos' }",
             "{ '$group': { '_id': '$productionPartInfos.publisherId', 'qty': { '$push': '$qty' } } }",
            "{ '$project': { 'qty': { '$reduce': { 'input': '$qty', 'initialValue': [], 'in': { '$concatArrays': [ '$$value', '$$this' ] } } } } }",
            "{ '$project': { 'total': { '$sum': [ '$qty' ] } } }",
            "{'$project': {'client': '$_id', '_id': 0,'total': 1}}"
    })
    List<HashMap> findWorkPlanifiedByPageAndClient();
    @Aggregation(pipeline = {
            "{ '$match': { 'status': { '$in': [ 'ON PROD', 'SCHEDULED', 'ASSIGNED' ] } } }",
            "{ '$project': { 'productionPartInfos.colors': 1, 'qty': { '$map': { 'input': '$productionPartInfos', 'as': 'grade', 'in': { '$add': [ { '$multiply': [ '$$grade.productionPage', '$$grade.qtyRequested' ] } ] } } } } }",
            "{ '$unwind': '$productionPartInfos' }",
            "{ '$group': { '_id': '$productionPartInfos.colors', 'qty': { '$push': '$qty' } } }",
            "{ '$project': { 'qty': { '$reduce': { 'input': '$qty', 'initialValue': [], 'in': { '$concatArrays': [ '$$value', '$$this' ] } } } } }",
            " { '$project': { 'total': { '$sum': [ '$qty' ] } } }",
            "{ '$project': { 'color': '$_id', '_id': 0, 'total': 1 } }"
    })
    List<HashMap> findWorkPlanifiedByPageAndColor();

    @Aggregation(pipeline = {
            "{ '$match': { 'status': { '$in': [ 'ON PROD', 'SCHEDULED', 'ASSIGNED' ] } } }",
            "{ '$project': { 'productionPartInfos': '$productionPartInfos', 'length': 1, 'duration': 1 } }",
            "{ '$unwind': '$productionPartInfos' }",
            "{'$project': { 'length': 1, 'duration': 1, 'pages': '$productionPartInfos.productionPage', 'colors': '$productionPartInfos.colors', 'client': '$productionPartInfos.publisherId' } }",
            "{ '$match': { 'colors': 4 } }",
            "{ '$group': { '_id': '$client', 'pages': { '$sum': '$pages' }, 'duration': { '$sum': '$duration' }, 'length': { '$sum': '$length' } } }",
            "{ '$project': { 'client': '$_id', 'Pages': '$pages', 'Hours': '$duration', 'Meters': '$length', '_id': 0 } } "
    })
    List<HashMap> findJobReportBy4Colors();
    @Aggregation(pipeline = {
            "{ '$match': { 'status': { '$in': [ 'ON PROD', 'SCHEDULED', 'ASSIGNED' ] } } }",
            "{ '$project': { 'productionPartInfos': '$productionPartInfos', 'length': 1, 'duration': 1 } }",
            "{ '$unwind': '$productionPartInfos' }",
            "{'$project': { 'length': 1, 'duration': 1, 'pages': '$productionPartInfos.productionPage', 'colors': '$productionPartInfos.colors', 'client': '$productionPartInfos.publisherId' } } }",
            "{ '$match': { 'colors': 1 } }",
            "{ '$group': { '_id': '$client', 'pages': { '$sum': '$pages' }, 'duration': { '$sum': '$duration' }, 'length': { '$sum': '$length' } } }",
            "{ '$project': { 'client': '$_id', 'Pages': '$pages', 'Hours': '$duration', 'Meters': '$length', '_id': 0 } } "
    })
    List<HashMap> findJobReportBy1Colors();

}
