package com.sk.shoping.shoping.services;

import com.sk.shoping.shoping.entity.Orders;
import com.sk.shoping.shoping.model.Order;
import com.sk.shoping.shoping.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImp implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Orders saveOrder(Orders order) {
        return orderRepository.save(order);

    }

    @Override
    public List<Orders> getOrder() {
        return orderRepository.findAll();
    }

    @Override
    public boolean validate(String orderId) {
        Optional<Orders> or=orderRepository.findById(orderId);
        return or.isPresent();
    }
}
