package com.sk.shoping.shoping.services;

import com.sk.shoping.shoping.entity.Orders;
import com.sk.shoping.shoping.model.Order;

import java.util.List;

public interface OrderService {
    Orders saveOrder(Orders order);

    List<Orders> getOrder();
    boolean validate(String orderId);
}
