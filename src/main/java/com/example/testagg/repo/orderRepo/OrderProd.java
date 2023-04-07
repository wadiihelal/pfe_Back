package com.example.testagg.repo.orderRepo;

import com.example.testagg.repo.orderRepo.OrdersProduction;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProd extends MongoRepository<OrdersProduction,Integer> {
    @Aggregation(pipeline =
                {"{ '$match': { 'productionParts.parentId': { '$in': [0,-1] } },}",
                        "{ '$group': { '_id': { 'clientId': '$clientId', 'year': { '$year': '$dateReceipt' }, 'month': { '$month': '$dateReceipt' }, 'day': { '$dayOfMonth': '$dateReceipt' } }, 'info': { '$push': { 'id': '$_id', 'qtyMax':  { '$last': '$productionParts.qtyMax' } ,'qtyDelivered':  { '$last': '$productionParts.qtyDelivered' } , 'nbpage': { '$first': '$productionParts.productionPage' } ,  'length': { '$first': '$productionParts.length' } , 'hours': { '$first': '$productionParts.hours' } } }, 'date': { '$first': '$dateReceipt' } } }",
                        "{ '$sort': { 'date': 1 } }",
                        " { '$project': { '_id': 0 } }"})
    List <OrdersProduction> findProductionByDay();
}