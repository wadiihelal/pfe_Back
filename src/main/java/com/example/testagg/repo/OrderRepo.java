package com.example.testagg.repo;

import com.example.testagg.model.Order;
import com.example.testagg.model.OrdersProduction;
import com.example.testagg.model.Pm;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
@Repository
public interface OrderRepo extends MongoRepository<Order,Integer> {

    @Aggregation(pipeline = {"{'$match':{'status' : 'PENDING'}}",})
    List<Order> findPendingOrders();

    @Aggregation(pipeline = {"{'$match':{'status' : 'COMPLETE' , 'clientId':  'Epac'}}",})
    List<Order> findCompletedOrder();

    @Query("{{'dateExpacted' : :#{#dateExpacted}},'status':'ACCEPTED'}")
    List<Order> findAcceptedOrderByDateExpacted(Date dateExpacted);
    @Query("{{'dateExpacted' : :#{#dateExpacted}},'status':'ONPROD'}")
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
            {"{'$match':{  status:{$in:[ 'COMPLETE','INVOICED','DELIVERED','ACCEPTED','PRODUCED' ]},'clientId':?1}}",
            "{'$group': {'_id': {'clientId': '$clientId','year': {'$year': '$dateExpacted'}, 'month': {'$month': '$dateExpacted'}},'length': {'$push': '$productionParts.length'}, 'year': { '$first': { '$year': '$dateExpacted' } }, }}",
            " {'$match': { 'year': ?0 } }",
            "{'$project': {'_id': '$_id', 'length': {'$reduce': {'input': '$length', 'initialValue': [], 'in': {'$concatArrays': ['$$value', '$$this']}}}}}",})
    List<Pm> getPm(int year, String clientId);
    @Aggregation(pipeline =
            {"{'$match': { 'status': { '$in': [ 'COMPLETE', 'INVOICED', 'DELIVERED', 'ACCEPTED', 'PRODUCED' ] }, } }",
            "{ '$group': { '_id': { 'clientId': '$clientId', 'year': { '$year': '$dateExpacted' } }, 'year': { '$first': { '$year': '$dateExpacted' } }, 'clientId': { '$first': '$clientId' } } }",
           " {'$match': { 'year': ?0 } }",
            "{ '$group': { '_id': { 'year': '$year' }, 'clients': { '$push': '$clientId' } } }",
            "{ '$project': { 'clients': 1, '_id': 0 } }"})
    List findClientsPmByYear(int year);
    @Aggregation(pipeline ={
            "{ '$group': { '_id': { 'clientId': '$clientId', 'year': { '$year': '$dateExpacted' } }, 'year': { '$first': { '$year': '$dateExpacted' } }, 'month': { '$first': { '$month': '$dateExpacted' } }, 'clientId': { '$first': '$clientId' } } }",
            "{ '$match': { 'year': ?0, 'month': ?1 } }",
            "{ '$group': { '_id': { 'year': '$year' }, 'clients': { '$push': '$clientId' } } }",
           "{ '$project': { 'clients': 1, '_id': 0 } }" })
    List findClientByYearAndMonth(int year,int month);

    @Aggregation(pipeline = {
            "{ '$match': { 'clientId': ?2 } }",
            "{ '$group': { '_id': { 'clientId': '$productionParts.clientId', 'bind': '$productionParts.bindingType' }, 'clientId': { '$first': '$productionParts.bindingType' }, 'year': { '$first': { '$year': '$dateExpacted' } }, 'month': { '$first': { '$month': '$dateExpacted' } } } }",
            "{ '$match': { 'year': ?0, 'month': ?1 } }",
            "{ '$group': { '_id': { 'year': '$year' }, 'clients': { '$push': '$clientId' } } }",
            "{ '$project': { '_id': 0, 'bindtype': { '$reduce': { 'input': '$clients', 'initialValue': [], 'in': { '$concatArrays': [ '$$value', '$$this' ] } } } } }",
            "{ '$project': { 'bindingtype': { '$setUnion': [ '$bindtype' ] } } }"
            })
    List getBindingTypeByClientAndByMonth(int year,int month,String clientId);

    @Aggregation(pipeline ={
            "{ '$match': { 'productionParts.parentId': { '$in': [ 0, -1 ] }, 'clientId': ?2, 'productionParts.bindingType': ?3} }",
            "{ '$group': { '_id': { 'clientId': '$clientId', 'year': { '$year': '$dateExpacted' }, 'month': { '$month': '$dateExpacted' }, 'day': { '$dayOfMonth': '$dateExpacted' } }, 'info': { '$push': { 'id': '$_id', 'qtyMax': { '$last': '$productionParts.qtyMax' }, 'qtyDelivered': { '$last': '$productionParts.qtyDelivered' }, 'nbpage': { '$first': '$productionParts.productionPage' }, 'length': { '$first': '$productionParts.length' }, 'hours': { '$first': '$productionParts.hours' } } }, 'date': { '$first': '$dateReceipt' }, 'year': { '$first': { '$year': '$dateExpacted' } }, 'month': { '$first': { '$month': '$dateExpacted' } } } }",
            "{ '$match': { 'year': ?0 ,'month': ?1 } }",
            "{ '$sort': { 'date': 1 } }",
            "{ '$project': { '_id': 0, 'year': 0, 'month': 0 } }",
            })
    List <OrdersProduction> getWorkByMonthAndClient(int year, int month, String clientId, String bindingType);
}
