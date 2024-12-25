package com.sk.shoping.shoping.controller;

import com.sk.shoping.shoping.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    //create
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        User user1 = orderService.saveOrder(order);
        return  ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
    //single user get
    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId ){
        User user=userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

}

