package com.sk.shoping.shoping.controller;

import com.sk.shoping.shoping.entity.Orders;
import com.sk.shoping.shoping.model.Order;
import com.sk.shoping.shoping.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    //create
    @PostMapping
    public ResponseEntity<Orders> createOrder(@RequestBody Order orderModel, @RequestHeader("role") String role, @RequestHeader("username") String username){
        if(role.equals("PUBLISHER")) {
            Orders orders=new Orders();
            orders.setRecordId(orderModel.getRecordId());
            orders.setTaskId(orderModel.getTaskId());
            orders.setPartsPrice(orderModel.getPartsPrice());
            orders.setLabourPrice(orderModel.getLabourPrice());
            orders.setAmount(orderModel.getAmount());

            orders.setStatus("created");
            orders.setCreatedBy(username);
            Orders orderRes = orderService.saveOrder(orders);
            return  ResponseEntity.status(HttpStatus.OK).body(orderRes);
        }else if(role.equals("REVIEWER")){


            boolean vali=orderService.validate(orderModel.getRecordId());
            if(vali) {
                Orders orders=new Orders();
                orders.setRecordId(orderModel.getRecordId());
                orders.setTaskId(orderModel.getTaskId());
                orders.setPartsPrice(orderModel.getPartsPrice());
                orders.setLabourPrice(orderModel.getLabourPrice());
                orders.setAmount(orderModel.getAmount());
                orders.setStatus(orderModel.getStatus());
                orders.setCreatedBy(orderModel.getCreatedBy());
                orders.setUpdatedBy(username);
                orders.setReviewSummary(orderModel.getReviewSummary());
                Orders order1 = orderService.saveOrder(orders);
                return ResponseEntity.status(HttpStatus.OK).body(order1);
            }else{
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        }
        else if(role.equals("APPROVER")){
            Orders orders=new Orders();
            orders.setRecordId(orderModel.getRecordId());
            orders.setTaskId(orderModel.getTaskId());
            orders.setPartsPrice(orderModel.getPartsPrice());
            orders.setLabourPrice(orderModel.getLabourPrice());
            orders.setAmount(orderModel.getAmount());
            orders.setStatus(orderModel.getStatus());
            orders.setCreatedBy(orderModel.getCreatedBy());
            orders.setUpdatedBy(username);
            orders.setReviewSummary(orderModel.getReviewSummary());
            Orders order1 = orderService.saveOrder(orders);
            return ResponseEntity.status(HttpStatus.OK).body(order1);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

    }
    //All Order get
    @GetMapping
    public ResponseEntity<List<Orders>> getAllOrder( @RequestHeader("role") String role, @RequestHeader("username") String username){
        List<Orders> orders=orderService.getOrder();
        return ResponseEntity.status(HttpStatus.CREATED).body(orders);
    }

}

