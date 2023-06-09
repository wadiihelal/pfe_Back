package com.example.testagg.controller;

import com.example.testagg.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;


@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping ("/getProducted")
    public TreeMap findProductedOrder(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
        return orderService.findProductedOrderByDate(date);
    }
    @GetMapping("/getProcessing")
    public TreeMap findProcessingOrder(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date){
        return orderService.findProcessingOrderByDate(date);
    }
    @GetMapping("/get-pm")
    public Object[] findPmStats(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date, @RequestParam String clientId)  {
        return orderService.findPM(date,clientId);
    }
    @GetMapping("/get-pm-clients")
    public List findClientsPm(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) throws ParseException {
        return orderService.findClientsPm(date);
    }

    //    @GetMapping
//    public List getOrdersByClient() throws Exception {
//        return orderService.get();
//    }
    @GetMapping("/get-pm-clients-by-month")
    public List findClientsByYearAndMonth(@RequestParam int year,@RequestParam int month,@RequestParam String type)  {
        return orderService.findClientByYearAndMonth(year, month,type);
    }


    @GetMapping("/get-bind-tp-by-client")
    public List getBindingTypeByClientAndByMonth(@RequestParam int year,@RequestParam int month,@RequestParam String clientId){
        return orderService.getBindingTypeByClientAndByMonth(year, month,clientId);
    }

    @GetMapping("/get-mensual-work")
        public  List getWorkByMonthAndClient(@RequestParam int year,@RequestParam int month,@RequestParam String[] clientId,@RequestParam String[] bindingType,@RequestParam String type) throws IOException {
        return orderService.getWorkByMonthAndClient(year,month,clientId,bindingType,type);
    }

    @GetMapping("/client-year-pages")
    public List getPrintedPageByClientByYear(@RequestParam int year){
        return orderService.getPrintedPageByClientByYear(year);
    }
    @GetMapping("/client-year-qty-req")
    public List getQuantityRequestedByClientByYear(@RequestParam int year){
        return orderService.getQuantityRequestedByClientByYear(year);
    }
    @GetMapping("/paper-length-year")
    public List getLengthByPaper(@RequestParam int year){
        return orderService.getLengthByPaper(year);
    }
    @GetMapping("/bindtype-length-year")
    public List getLengthByBindingType(@RequestParam int year){
        return orderService.getLengthByBindingType(year);
    }
    @GetMapping("/bindtype-qty-year")
    public List getBindingTypeByQtyRequestedAndYear(@RequestParam int year){
        return orderService.getBindingTypeByQtyRequestedAndYear(year);
    }
    @GetMapping("/bindtype-page-year")
    public List getBindingTypeByPagesAndYear(@RequestParam int year){
        return orderService.getBindingTypeByPagesAndYear(year);
    }
//    @GetMapping("/pending")
//    public List getPendingOrders() {
//        return orderService.getPendingOrders();
//    }
//    @GetMapping("/client/pending")
//    public HashMap getPendingClients() {
//        return orderService.getPendingClients();
//    }
//    @GetMapping("/client/pending/{colorNumber}")
//    public HashMap getPendingClientsByColor(@PathVariable Long colorNumber) {
//        return orderService.getPendingClientsByColor(colorNumber);
//    }


}
