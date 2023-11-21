package com.go.GreatOutdoor_Order.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.go.GreatOutdoor_Order.Entity.Orders;

public interface OrdersRepo extends JpaRepository<Orders, Integer> {
 
}