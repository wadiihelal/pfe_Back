package com.example.testagg.service;

import com.example.testagg.model.Order;
import com.example.testagg.model.OrdersProduction;
import com.example.testagg.model.Pm;
import com.example.testagg.repo.OrderProd;
import com.example.testagg.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.fasterxml.jackson.core.io.NumberInput.parseDouble;

@Service
public class OrderService {

    @Autowired
    private OrderRepo repo;
    @Autowired
    private OrderProd prod;

    public TreeMap findProductedOrderByDate(Date date) {
        TreeMap output = new TreeMap();
        Instant instant = date.toInstant();
        Instant nextDay = instant.plus(-1, ChronoUnit.DAYS);
        Instant previous = instant.plus(-2, ChronoUnit.DAYS);
        output.put(Date.from(previous),calculateInformation(callProductionOrdersByDateBefore(Date.from(previous)),Date.from(previous)));
        for(int i=0;i<11;i++) {
            output.put(Date.from(nextDay),calculateInformation(callProductionOrdersByDateSpecific(Date.from(nextDay)),Date.from(nextDay)));
            nextDay = nextDay.plus(1, ChronoUnit.DAYS);
        }
        output.put(Date.from(nextDay),calculateInformation(callProductionOrdersByDateAfter(Date.from(nextDay)),Date.from(nextDay)));
        //        List <Order>result = Stream.of(repo.findOrdersByDateExpacted(Date.from(nextDay),"ONPROD"),repo.findOrdersByDateExpacted(Date.from(previous),"ACCEPTED"))
//                .flatMap(Collection::stream)
//                .collect(Collectors.toList());
        //calculateInformation(repo.findOrdersByDateExpactedBeforeAndStatus(date,"INVOICED"));
        //return repo.findOrdersByDateExpactedBeforeAndStatus(date,"ACCEPTED");
        return output;
    }
    public TreeMap findProcessingOrderByDate(Date date) {
        TreeMap output = new TreeMap();
        //output.put()
        //ArrayList <Order> output = new ArrayList();
        Instant instant = date.toInstant();
        Instant nextDay = instant.plus(-1, ChronoUnit.DAYS);
        Instant previous = instant.plus(-2, ChronoUnit.DAYS);
        output.put(Date.from(previous),calculateInformation(callProcessingOrdersByDateBefore(Date.from(previous)),Date.from(previous)));
        for(int i=0;i<11;i++) {
            output.put(Date.from(nextDay),calculateInformation(callProcessingOrdersByDateSpecific(Date.from(nextDay)),Date.from(nextDay)));
            nextDay = nextDay.plus(1, ChronoUnit.DAYS);
        }
        output.put(Date.from(nextDay),calculateInformation(callProcessingOrdersByDateAfter(Date.from(nextDay)),Date.from(nextDay)));
        //        List <Order>result = Stream.of(repo.findOrdersByDateExpacted(Date.from(nextDay),"ONPROD"),repo.findOrdersByDateExpacted(Date.from(previous),"ACCEPTED"))
//                .flatMap(Collection::stream)
//                .collect(Collectors.toList());
        //calculateInformation(repo.findOrdersByDateExpactedBeforeAndStatus(date,"INVOICED"));
        //return repo.findOrdersByDateExpactedBeforeAndStatus(date,"ACCEPTED");
        return output;
    }
        public List<Order> getPendingOrders() {
        return repo.findPendingOrders();
    }

//    public HashMap getPendingClients() {
//        List clients = new ArrayList();
//        List<Order> list = this.getPendingOrders();
//        HashMap clientMap = new HashMap<String,Long>();
//        for(Order i : list) {
//            clients.add(i.getClientId());
//        }
//        Set<String> distinct = new HashSet<>(clients);
//        for (String s: distinct) {
//            clientMap.put(s,Collections.frequency(clients, s));
//        }
//
//
//        return clientMap;
//    }
//    public HashMap getPendingClientsByColor(Long colorNumber) {
//        List clients = new ArrayList();
//        HashMap clientMap = new HashMap<String,Long>();
//        List<Order> list = this.getPendingOrders();
//        for(Order i : list) {
//            if(i.getProductionParts()[0].getColors()==colorNumber) {
//                clients.add((i.getClientId()));
//            }
//        }
//        Set<String> distinct = new HashSet<>(clients);
//        for (String s: distinct) {
//            clientMap.put(s,Collections.frequency(clients, s));
//        }
//        return clientMap;
//    }
//
//    public HashMap getOrdersByClient() {
//        List clients = new ArrayList();
//        List<Order> list = repo.findAll();
//        HashMap clientMap = new HashMap<String,Long>();
//        for(Order i : list) {
//            clients.add(i.getStatus());
//        }
//        System.out.println(clients+"clients");
//        Set<String> distinct = new HashSet<>(clients);
//        for (String s: distinct) {
//            clientMap.put(s,Collections.frequency(clients, s));
//        }
//        return clientMap;
//    }

    public  List callProductionOrdersByDateSpecific(Date date) {
        List <Order> tmpListOnProd = repo.findOrdersByDateExpactedAndStatus(date,"ONPROD");
        List <Order> tmpListAccepted = repo.findOrdersByDateExpactedAndStatus(date,"ACCEPTED");
        List<Order> newList = Stream.of(tmpListAccepted, tmpListOnProd)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        return  newList;
    }
    public  List callProcessingOrdersByDateSpecific(Date date) {
        List <Order> tmpListOnHold = repo.findOrdersByDateExpactedAndStatus(date,"ONHOLD");
        List <Order> tmpListProof = repo.findOrdersByDateExpactedAndStatus(date,"PROOF");
        List <Order> tmpListProofOut = repo.findOrdersByDateExpactedAndStatus(date,"PROOF OUT");
        List <Order> tmpListPending = repo.findOrdersByDateExpactedAndStatus(date,"PENDING");
        List <Order> tmpListPreCheck = repo.findOrdersByDateExpactedAndStatus(date,"PRE CHECK");
        List<Order> newList = Stream.of( tmpListOnHold,tmpListProof,tmpListProofOut,tmpListPending,tmpListPreCheck)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        return  newList;
    }
    public  List callProductionOrdersByDateBefore(Date date) {
        List <Order> tmpListOnProd = repo.findOrdersByDateExpactedBeforeAndStatus(date,"ONPROD");
        List <Order> tmpListAccepted = repo.findOrdersByDateExpactedBeforeAndStatus(date,"ACCEPTED");
        List<Order> newList = Stream.of(tmpListAccepted, tmpListOnProd)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        return  newList;
    }
    public  List callProcessingOrdersByDateBefore(Date date) {
        List <Order> tmpListOnHold = repo.findOrdersByDateExpactedBeforeAndStatus(date,"ONHOLD");
        List <Order> tmpListProof = repo.findOrdersByDateExpactedBeforeAndStatus(date,"PROOF");
        List <Order> tmpListProofOut = repo.findOrdersByDateExpactedBeforeAndStatus(date,"PROOF OUT");
        List <Order> tmpListPending = repo.findOrdersByDateExpactedBeforeAndStatus(date,"PENDING");
        List <Order> tmpListPreCheck = repo.findOrdersByDateExpactedBeforeAndStatus(date,"PRE CHECK");
        List<Order> newList = Stream.of(tmpListOnHold, tmpListProof,tmpListProofOut,tmpListPending,tmpListPreCheck)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        return  newList;
    }
    public  List callProductionOrdersByDateAfter(Date date) {
        List <Order> tmpListOnProd = repo.findOrdersByDateExpactedAfterAndStatus(date,"ONPROD");
        List <Order> tmpListAccepted = repo.findOrdersByDateExpactedAfterAndStatus(date,"ACCEPTED");
        List<Order> newList = Stream.of(tmpListAccepted, tmpListOnProd)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        return  newList;
    }
    public  List callProcessingOrdersByDateAfter(Date date) {
        List <Order> tmpListProof = repo.findOrdersByDateExpactedAfterAndStatus(date,"PROOF");
        List <Order> tmpListOnHold = repo.findOrdersByDateExpactedAfterAndStatus(date,"ONHOLD");
        List <Order> tmpListProofOut = repo.findOrdersByDateExpactedAfterAndStatus(date,"PROOF OUT");
        List <Order> tmpListPending = repo.findOrdersByDateExpactedAfterAndStatus(date,"PENDING");
        List <Order> tmpListPreCheck = repo.findOrdersByDateExpactedAfterAndStatus(date,"PRE CHECK");
        List<Order> newList = Stream.of(tmpListOnHold, tmpListProof,tmpListProofOut,tmpListPending,tmpListPreCheck)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        return  newList;
    }



    public TreeMap findProcessingOrder(Date date) {

        return findProductedOrderByDate(date);
    }
    public List getFiltered() {
        List<Order> result = repo.findAll();
        result
                .stream()
                .filter(c -> c.getStatus() =="COMPLETE")
                .collect(Collectors.toList());
        return result;

    }
    public HashMap calculateInformation(List <Order> list,Date date) {
            HashMap result = new HashMap();
            result.put("date",date);
            result.put("orderQty",list.size());
            int bookQty=0;
            double hours=0;
        for (Order order: list) {
            for (int i = 0; i < order.getProductionParts().length; i++) {
                bookQty+=order.getProductionParts()[i].getQtyRequested();
                hours+=order.getProductionParts()[i].getHours();
            }
                 }
        result.put("bookQty",bookQty);
        result.put("ProdDuration",hours);
        return result;

    }

    public  Date convertLocalDateToDate(LocalDate localDate) {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        return Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
    }
    public List findPmStats(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateExpactedBefore, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateExpactedAfter, String status){
        List <String> fields=Arrays.asList("ACCEPTED","COMPLETE","DELIVERED","PRODUCED","INVOICED");
        LocalDateTime now = LocalDateTime.now();
        while (now.getYear()>=2022) {
            LocalDate date1 = LocalDate.of(now.getYear(), 1, 1);
            now = now.minusYears(1);
            LocalDate date2 = LocalDate.of(now.getYear(), 1, 1);



        }
        //orderStatRepo.saveAll(repo.findOrdersByDateExpactedBetweenAndStatus(Date.from(now.atZone(ZoneId.systemDefault()).toInstant()), dateExpactedAfter, status));
        return  repo.findOrdersByDateExpactedBetweenAndStatus(Date.from(now.atZone(ZoneId.systemDefault()).toInstant()),dateExpactedAfter,status);
    }

    public Object[] findPM(Date date , String clientId){
        int year=date.getYear()+1900;

        List<Pm> result = new ArrayList<>(repo.getPm(year,clientId));
        List<String> fin = new ArrayList();
        List <HashMap> output=new ArrayList();
        Object[] sorted = new Object[12];
        for(Pm pm : result) {
            if(pm.getLength().length>0)
                output.add(calculateProductionPm(pm));
        }

        for (HashMap pm : output){
            fin.add(pm.get("month").toString());
        }
        String[] monthNames = {"JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};
        for (int i =0 ;i<12;i++) {
            if(!fin.contains(monthNames[i].toUpperCase())){
                HashMap inter = new HashMap<>();
                inter.put("month",monthNames[i]);
                inter.put("sum",0);
                output.add(inter);
            }
        }
        for(HashMap objet : output) {
            for (String month:monthNames){
                if (month.equals(objet.get("month"))){
                    sorted[Arrays.stream(monthNames).toList().indexOf(month)]=objet;
                }
            }

        }
        return sorted;

    }

    public HashMap calculateProductionPm(Pm pm) {
        HashMap result= new HashMap();
        Long sum = 0L;
        for(int i=0;i<pm.getLength().length;i++){
            if (pm.getLength().length >= 1) {
                sum=sum+pm.getLength()[i];
            }
            // Create a month instance
            Month month = Month.of((Integer) pm.id.get("month"));
            //result.put(month,sum/1000);
            result.put("month",month.toString());
            result.put("sum",sum/1000);
        }



        return result;
    }


    public List findClientsPm(Date date) {
        int year=date.getYear()+1900;
        return repo.findClientsPmByYear(year);
    }
    public List findClientByYearAndMonth(int year,int month){
        return repo.findClientByYearAndMonth(year, month);
    }

    public List <OrdersProduction> get(List <OrdersProduction> modifiable) throws IOException {
        ArrayList allOutput=new ArrayList<HashMap>();
        Double quantityMax=0D;
        Double quantityDelivered=0D;
        Double pages=0D;
        Double length=0D;
        Double value=0D;
        Instant previousDay = null;
        List <OrdersProduction>result = new ArrayList<>();
        for(int i=0;i<(modifiable.size()-1);i++) {
            if(!(modifiable.get(i+1).getDate().equals(modifiable.get(i).getDate())) ){
                result.add(modifiable.get(i));
                System.out.println(modifiable.get(i).getDate());
            }
        }
            for (OrdersProduction res : result){
            HashMap output=new HashMap<>();
            for(int i=0;i<res.getInfo().size();i++){
                Double qtyDelivered = parseDouble(res.getInfo().get(i).get("qtyDelivered").toString());
                quantityDelivered=quantityDelivered+qtyDelivered;
                Double qtyMax = parseDouble(res.getInfo().get(i).get("qtyMax").toString());
                quantityMax=quantityMax+qtyMax;
                Double pg = parseDouble(res.getInfo().get(i).get("nbpage").toString());
                pages=pages+pg;
                value=value+(qtyMax*pg);
                Double lg = parseDouble(res.getInfo().get(i).get("length").toString());
                length=length+lg;
            }

            String dateOutput = res.getDate().toInstant().toString().substring(0, 10);
            output.put("date",dateOutput);
            output.put("totalJobs",res.getInfo().size());
            output.put("qtyDelivered",quantityDelivered.intValue());
            output.put("qtyMax",quantityMax.intValue());
           // output.put("length",length);
            output.put("totalQuantityByDay",value.intValue());
            quantityMax=quantityDelivered=length=pages=value=0D;
            if(res.getDate().toInstant()!=previousDay)
                allOutput.add((output));
            previousDay=res.getDate().toInstant();



        }
        return allOutput;
    }

    public List getBindingTypeByClientAndByMonth(int year,int month,String clientId ){
        return repo.getBindingTypeByClientAndByMonth(year, month,clientId);
    }

    public List getWorkByMonthAndClient(int year, int month, String clientId, String bindingType) throws IOException {
        return get(repo.getWorkByMonthAndClient(year,month,clientId,bindingType));
    }
}
