package com.example.testagg.repo.orderRepo;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
@Repository
public interface OrderRepo extends MongoRepository<Order,Integer> {

    @Aggregation(pipeline = {"{'$match':{'status' : 'PENDING'}}",})
    List<Order> findPendingOrders();

    @Aggregation(pipeline = {"{'$match':{'status' : 'COMPLETE' , 'clientId':  'Epac'}}",})
    List<Order> findCompletedOrder();

    @Query("{{'dateExpacted' : :#{#dateExpacted}},'status':'ACCEPTED'}")
    List<Order> findAcceptedOrderByDateExpacted(Date dateExpacted);
    @Query("{{'dateExpacted' : :#{#dateExpacted}},'status':'ON PROD'}")
    List<Order> findOnProdOrderByDateExpacted(Date dateExpacted);

    @Aggregation(pipeline = {"{'$match':{'status' : 'ONHOLD'}}",})
    List<Order> findOnHoldOrder();

    @Aggregation(pipeline = {"{'$match':{'status' : 'PROOF'}}",})
    List<Order> findProofOrder();

    @Aggregation(pipeline = {"{'$match':{'status' : 'PROOF OUT'}}",})
    List<Order> findProofOutOrderByDa();
//    @Aggregation(pipeline = {"{'$match':{'status' : 'PROOF OUT'}}",})
//    List<Order> findPreCheckOrder();


    List<Order> findOrdersByDateExpactedAndStatus(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateExpacted,String status);
    List<Order> findOrdersByDateExpactedBeforeAndStatus(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateExpacted,String status);
    //@Query("{'dateExpacted' :  {$gte : ?0}, status :  ?1}")
    //@Aggregation(pipeline = {"{'$match':{'dateExpacted' : {$gte :?0}}}",})
    List<Order> findOrdersByDateExpactedAfterAndStatus(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateExpacted,String status);

    List<Order>findOrdersByDateExpactedBetweenAndStatus(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateExpactedBefore,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateExpactedAfter,String status);

    @Aggregation(pipeline =
            {"{'$match':{  status:{$in:[ 'COMPLETE','INVOICED','DELIVERED','ACCEPTED','PARTIAL DELIVERED'  ]},'clientId':?1}}",
            "{'$group': {'_id': {'clientId': '$clientId','year': {'$year': '$dateExpacted'}, 'month': {'$month': '$dateExpacted'}},'length': {'$push': '$productionParts.length'}, 'year': { '$first': { '$year': '$dateExpacted' } }, }}",
            " {'$match': { 'year': ?0 } }",
            "{'$project': {'_id': '$_id', 'length': {'$reduce': {'input': '$length', 'initialValue': [], 'in': {'$concatArrays': ['$$value', '$$this']}}}}}",})
    List<Pm> getPm(int year, String clientId);
    @Aggregation(pipeline =
            {"{'$match': { 'status': { '$in': [ 'COMPLETE', 'INVOICED', 'DELIVERED', 'PRODUCED','PARTIAL DELIVERED'  ] }, } }",
            "{ '$group': { '_id': { 'clientId': '$clientId', 'year': { '$year': '$dateExpacted' } }, 'year': { '$first': { '$year': '$dateExpacted' } }, 'clientId': { '$first': '$clientId' } } }",
           " {'$match': { 'year': ?0 } }",
            "{ '$group': { '_id': { 'year': '$year' }, 'clients': { '$push': '$clientId' } } }",
            "{ '$project': { 'clients': 1, '_id': 0 } }"})
    List findClientsPmByYear(int year);



    @Aggregation(pipeline ={
            "{'$match': { 'status': { '$in': [ 'COMPLETE', 'INVOICED', 'DELIVERED', 'PRODUCED' ,'PARTIAL DELIVERED' ] }, } }",
            "{ '$group': { '_id': { 'clientId': '$clientId', 'year': { '$year': '$dateReceipt' } , 'date':'$dateReceipt'}, 'year': { '$first': { '$year': '$dateReceipt' } }, 'month': { '$first': { '$month': '$dateReceipt' } }, 'clientId': { '$first': '$clientId' } } }",
            "{ '$match': { 'year': ?0, 'month': ?1 } }",
            "{ '$group': { '_id': { 'year': '$year' }, 'clients': { '$push': '$clientId' } } }",
           "{ '$project': { 'clients': 1, '_id': 0 } }",
            "{ '$project': { 'clients': { '$setUnion': [ '$clients' ] } } }"
    })
    List findClientByYearAndMonthReceipt(int year,int month);
    @Aggregation(pipeline ={
            "{'$match': { 'status': { '$in': [ 'COMPLETE', 'INVOICED', 'DELIVERED', 'PRODUCED','PARTIAL DELIVERED'  ] }, } }",
            "{ '$group': { '_id': { 'clientId': '$clientId', 'year': { '$year': '$dateExpacted' } , 'date':'$dateExpacted'}, 'year': { '$first': { '$year': '$dateExpacted' } }, 'month': { '$first': { '$month': '$dateExpacted' } }, 'clientId': { '$first': '$clientId' } } }",
            "{ '$match': { 'year': ?0, 'month': ?1 } }",
            "{ '$group': { '_id': { 'year': '$year' }, 'clients': { '$push': '$clientId' } } }",
           "{ '$project': { 'clients': 1, '_id': 0 } }",
            "{ '$project': { 'clients': { '$setUnion': [ '$clients' ] } } }"
    })
    List findClientByYearAndMonthExpacted(int year,int month);

    @Aggregation(pipeline = {
            "{'$match': { 'status': { '$in': [ 'COMPLETE', 'INVOICED', 'DELIVERED', 'PRODUCED','PARTIAL DELIVERED'  ] }, } }",
            "{ '$match': { 'clientId': ?2 } }",
            "{ '$group': { '_id': { 'clientId': '$productionParts.clientId', 'bind': '$productionParts.bindingType','date': '$dateReceipt' }, 'clientId': { '$first': '$productionParts.bindingType' }, 'year': { '$first': { '$year': '$dateReceipt' } }, 'month': { '$first': { '$month': '$dateReceipt' } } } }",
            "{ '$match': { 'year': ?0, 'month': ?1 } }",
            "{ '$group': { '_id': { 'year': '$year' }, 'clients': { '$push': '$clientId' } } }",
            "{ '$project': { '_id': 0, 'bindtype': { '$reduce': { 'input': '$clients', 'initialValue': [], 'in': { '$concatArrays': [ '$$value', '$$this' ] } } } } }",
            "{ '$project': { 'bindingtype': { '$setUnion': [ '$bindtype' ] } } }"
            })
    List getBindingTypeByClientAndByMonth(int year,int month,String clientId);
    @Aggregation(pipeline = {
            "{'$match': { 'status': { '$in': [ 'COMPLETE', 'INVOICED', 'DELIVERED', 'PRODUCED','PARTIAL DELIVERED'  ] }, } }",
            "{ '$group': { '_id': { 'clientId': '$productionParts.clientId', 'bind': '$productionParts.bindingType','date': '$dateReceipt' }, 'clientId': { '$first': '$productionParts.bindingType' }, 'year': { '$first': { '$year': '$dateReceipt' } }, 'month': { '$first': { '$month': '$dateReceipt' } } } }",
            "{ '$match': { 'year': ?0, 'month': ?1 } }",
            "{ '$group': { '_id': { 'year': '$year' }, 'clients': { '$push': '$clientId' } } }",
            "{ '$project': { '_id': 0, 'bindtype': { '$reduce': { 'input': '$clients', 'initialValue': [], 'in': { '$concatArrays': [ '$$value', '$$this' ] } } } } }",
            "{ '$project': { 'bindingtype': { '$setUnion': [ '$bindtype' ] } } }"
            })
    List getBindingTypeByClientAndByMonthALL(int year,int month);

    @Aggregation(pipeline ={
            "{'$match': { 'status': { '$in': [ 'COMPLETE', 'INVOICED', 'DELIVERED', 'PRODUCED' ,'PARTIAL DELIVERED' ] }, } }",
            "{ '$match': { 'productionParts.parentId': { '$in': [ 0, -1 ] }, 'clientId': ?2, 'productionParts.bindingType': ?3} }",
            "{ '$group': { '_id': { 'clientId': '$clientId', 'year': { '$year': '$dateReceipt' }, 'month': { '$month': '$dateReceipt' }, 'day': { '$dayOfMonth': '$dateReceipt' } }, 'info': { '$push': { 'id': '$_id', 'qtyMax': { '$last': '$productionParts.qtyMax' }, 'qtyDelivered': { '$last': '$productionParts.qtyDelivered' }, 'nbpage': { '$first': '$productionParts.productionPage' }, 'length': { '$first': '$productionParts.length' }, 'hours': { '$first': '$productionParts.hours' } } }, 'date': { '$first': '$dateReceipt' }, 'year': { '$first': { '$year': '$dateReceipt' } }, 'month': { '$first': { '$month': '$dateReceipt' } } } }",
            "{ '$match': { 'year': ?0 ,'month': ?1 } }",
            "{ '$sort': { 'date': 1 } }",
            "{ '$project': { '_id': 0, 'year': 0, 'month': 0 } }",
            })
    List <OrdersProduction> getWorkByMonthAndClient(int year, int month, String clientId, String bindingType);
    @Aggregation(pipeline ={
            "{'$match': { 'status': { '$in': [ 'COMPLETE', 'INVOICED', 'DELIVERED', 'PRODUCED','PARTIAL DELIVERED'  ] }, } }",
            "{ '$match': { 'productionParts.parentId': { '$in': [ 0, -1 ] },} }",
            "{ '$match': { 'productionParts.bindingType': { '$in': ?3},'clientId': { '$in': ?2 },}} ",
            "{ '$group': { '_id': { 'clientId': '$clientId', 'year': { '$year': '$dateReceipt' }, 'month': { '$month': '$dateReceipt' }, 'day': { '$dayOfMonth': '$dateReceipt' } }, 'info': { '$push': { 'id': '$_id', 'qtyMax': { '$last': '$productionParts.qtyMax' }, 'qtyDelivered': { '$last': '$productionParts.qtyDelivered' }, 'nbpage': { '$first': '$productionParts.productionPage' }, 'length': { '$first': '$productionParts.length' }, 'hours': { '$first': '$productionParts.hours' } } }, 'date': { '$first': '$dateReceipt' }, 'year': { '$first': { '$year': '$dateReceipt' } }, 'month': { '$first': { '$month': '$dateReceipt' } } } }",
            "{ '$match': { 'year': ?0 ,'month': ?1 } }",
            "{ '$sort': { 'date': 1 } }",
            "{ '$project': { '_id': 0, 'year': 0, 'month': 0 } }",
            })
    List <OrdersProduction> getWorkByMonthAndYearAllClientAndAllBindingTypeReceipt(int year, int month, String[] clientId,String[] bindingType);
    @Aggregation(pipeline ={
            "{ '$match': { 'productionParts.parentId': { '$in': [ 0, -1 ] },} }",
            "{'$match': { 'status': { '$in': [ 'COMPLETE', 'INVOICED', 'DELIVERED','PRODUCED','PARTIAL DELIVERED' ] }, } }",
            "{ '$match': { 'productionParts.bindingType': { '$in': ?3},'clientId': { '$in': ?2 } } }",
            "{ '$group': { '_id': { 'clientId': '$clientId', 'year': { '$year': '$dateExpacted' }, 'month': { '$month': '$dateExpacted' }, 'day': { '$dayOfMonth': '$dateExpacted' } }, 'info': { '$push': { 'id': '$_id', 'qtyMax': { '$last': '$productionParts.qtyMax' }, 'qtyDelivered': { '$last': '$productionParts.qtyDelivered' }, 'nbpage': { '$first': '$productionParts.productionPage' }, 'length': { '$first': '$productionParts.length' }, 'hours': { '$first': '$productionParts.hours' } } }, 'date': { '$first': '$dateExpacted' }, 'year': { '$first': { '$year': '$dateExpacted' } }, 'month': { '$first': { '$month': '$dateExpacted' } } } }",
            "{ '$match': { 'year': ?0 ,'month': ?1 } }",
            "{ '$sort': { 'date': 1 } }",
            "{ '$project': { '_id': 0, 'year': 0, 'month': 0 } }",
            })
    List <OrdersProduction> getWorkByMonthAndYearAllClientAndAllBindingTypeExpacted(int year, int month, String[] clientId,String[] bindingType);


    @Aggregation(pipeline = {
            "{ '$match': { 'status': { '$in': [ 'COMPLETE', 'INVOICED', 'DELIVERED', 'PRODUCED' ] } } }",
            "{ '$project': { 'dateReceipt': 1, 'clientId': 1, 'qty': { '$map': { 'input': '$productionParts', 'as': 'grade', 'in': { '$add': [ { '$multiply': [ '$$grade.productionPage', '$$grade.qtyRequested' ] } ] } } } } }",
            "{ '$group': { '_id': { 'clientId': '$clientId', 'year': { '$year': '$dateReceipt' } }, 'year': { '$first': { '$year': '$dateReceipt' } }, 'qty': { '$push': '$qty' }, 'clientId': { '$first': '$clientId' } } }",
            "{ '$match': { 'year': ?0 } }",
            "{ '$project': { '_id': 0, 'clientId': 1, 'qty': { '$reduce': { 'input': '$qty', 'initialValue': [], 'in': { '$concatArrays': [ '$$value', '$$this' ] } } } } }",
            "{ '$project': { 'clientId': 1, 'total': { '$sum': [ '$qty' ] } } } "
    })
    List <HashMap>getPrintedPageByClientByYear(int year);


    @Aggregation(pipeline = {
            "{ '$match': { 'status': { '$in': [ 'COMPLETE', 'INVOICED', 'DELIVERED', 'PRODUCED' ] } } }",
            "{ '$project': { 'dateReceipt': 1, 'clientId': 1, 'qty': { '$map': { 'input': '$productionParts', 'as': 'grade', 'in': { '$add': [ { '$multiply': [ '$$grade.productionPage', 1 ] } ] } } } } }",
            "{ '$group': { '_id': { 'clientId': '$clientId', 'year': { '$year': '$dateReceipt' } }, 'year': { '$first': { '$year': '$dateReceipt' } }, 'qty': { '$push': '$qty' }, 'clientId': { '$first': '$clientId' } } }",
            "{ '$match': { 'year': ?0 } }",
            "{ '$project': { '_id': 0, 'clientId': 1, 'qty': { '$reduce': { 'input': '$qty', 'initialValue': [], 'in': { '$concatArrays': [ '$$value', '$$this' ] } } } } }",
            " { '$project': { 'clientId': 1, 'total': { '$sum': [ '$qty' ] } } }"
    })
    List<HashMap>getQuantityRequestedByClientByYear(int year);

    @Aggregation(pipeline = {
            "{ '$match': { 'status': { '$in': [ 'COMPLETE', 'INVOICED', 'DELIVERED', 'PRODUCED' ] } } }",
            "{ '$project': { 'dateReceipt': 1, 'clientId': 1, 'productionParts': 1 } }",
            "{ '$addFields': { 'paperType': { '$first': '$productionParts.textPaperType' } } }",
            "{ '$group': { '_id': { 'type': '$paperType', 'id': '$_id' }, 'year': { '$first': { '$year': '$dateReceipt' } }, 'qty': { '$push': '$productionParts.length' }, 'type': { '$first': '$paperType' } } }",
            "{ '$unwind': '$qty' }",
            "{'$match': { 'year': ?0 } }",
            "{ '$group': { '_id': '$type', 'qty': { '$push': '$qty' } } }",
            "{ '$unwind': '$qty' }",
            "{ '$project': { 'total': { '$sum': [ '$qty' ] } } }",
            "{ '$group': { '_id': '$_id', 'qty': { '$push': '$total' } } }",
            "{ '$project': { 'total': { '$sum': [ '$qty' ] } } } ",
            "{ '$project': { 'paper': '$_id', '_id': 0, 'total': 1 } }"
    })
    List<HashMap> getLengthByPaper(int year);
    @Aggregation(pipeline = {
            "{ '$match': { 'status': { '$in': [ 'COMPLETE', 'INVOICED', 'DELIVERED', 'PRODUCED' ] } } }",
            "{ '$project': { 'dateReceipt': 1, 'clientId': 1, 'productionParts': 1 } }",
            "{ '$addFields': { 'bindingType': { '$first': '$productionParts.bindingType' } } }",
            "{ '$group': { '_id': { 'bindingType': '$bindingType', 'id': '$_id' }, 'year': { '$first': { '$year': '$dateReceipt' } }, 'qty': { '$push': '$productionParts.length' }, 'type': { '$first': '$bindingType' } } }",
            "{ '$unwind': '$qty' }",
            "{ '$match': { 'year': ?0 } }",
            "{ '$group': { '_id': '$type', 'qty': { '$push': '$qty' } } }",
            "{ '$unwind': '$qty' }",
            "{ '$project': { 'total': { '$sum': [ '$qty' ] } } }",
            "{ '$group': { '_id': '$_id', 'qty': { '$push': '$total' } } }",
            "{ '$project': { 'total': { '$sum': [ '$qty' ] } } }",
            "{ '$project': { 'type': '$_id', '_id': 0, 'total': 1 } }"

    })
    List<HashMap>getLengthByBindingType(int year);
    @Aggregation(pipeline = {
            "{ '$match': { 'status': { '$in': [ 'COMPLETE', 'INVOICED', 'DELIVERED', 'PRODUCED' ] } } }",
            "{ '$project': { 'dateReceipt': 1, 'clientId': 1, 'productionParts': 1 } }",
            "{ '$addFields': { 'bindingType': { '$first': '$productionParts.bindingType' } } }",
            "{ '$group': { '_id': { 'bindingType': '$bindingType', 'id': '$_id' }, 'year': { '$first': { '$year': '$dateReceipt' } }, 'qty': { '$push': '$productionParts.qtyRequested' }, 'type': { '$first': '$bindingType' } } }",
            "{ '$unwind': '$qty' }",
            "{ '$match': { 'year': ?0 } }",
            "{ '$group': { '_id': '$type', 'qty': { '$push': '$qty' } } }",
            "{ '$unwind': '$qty' }",
            "{ '$project': { 'total': { '$sum': [ '$qty' ] } } }",
            "{ '$group': { '_id': '$_id', 'qty': { '$push': '$total' } } }",
            "{ '$project': { 'total': { '$sum': [ '$qty' ] } } }",
            "{ '$project': { 'type': '$_id', '_id': 0, 'total': 1 } }"

    })
        List<HashMap> getBindingTypeByQtyRequestedAndYear(int year);
    @Aggregation(pipeline = {
            "{ '$match': { 'status': { '$in': [ 'COMPLETE', 'INVOICED', 'DELIVERED', 'PRODUCED' ] } } }",
            "{ '$project': { 'dateReceipt': 1, 'clientId': 1, 'productionParts': 1, 'qty': { '$map': { 'input': '$productionParts', 'as': 'grade', 'in': { '$add': [ { '$multiply': [ '$$grade.productionPage', '$$grade.qtyRequested' ] } ] } } } } }",
            "{ '$addFields': { 'bindingType': { '$first': '$productionParts.bindingType' } } }",
            "{ '$project': { '_id': '$_id', 'bindingType': '$bindingType', 'dateReceipt': 1, 'qty': 1 } }",
            "{ '$group': { '_id': { 'type': '$bindingType', 'year': { '$year': '$dateReceipt' } }, 'qty': { '$push': '$qty' }, 'year': { '$first': { '$year': '$dateReceipt' } }, 'type': { '$first': '$bindingType' } } }",
            "{ '$match': { 'year': ?0 } }",
            "{ '$project': { 'qty': { '$reduce': { 'input': '$qty', 'initialValue': [], 'in': { '$concatArrays': [ '$$value', '$$this' ] } } }, 'type': 1, '_id': 0 } }",
            "{ '$project': { 'total': { '$sum': [ '$qty' ] }, 'type': 1 } }"
    })
    List<HashMap> getBindingTypeByPagesAndYear(int year);

}


