package com.sk.shoping.shoping.repository;

import com.sk.shoping.shoping.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders,String> {
}
