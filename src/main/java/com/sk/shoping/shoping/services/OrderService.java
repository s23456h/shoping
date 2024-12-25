package com.sk.shoping.shoping.services;

import com.sk.shoping.shoping.model.Order;

import java.util.List;

public interface OrderService {
    Order saveUser(Order order);

    Order getUser(String userId);
}
