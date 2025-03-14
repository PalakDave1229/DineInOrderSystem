package com.example.dine_in_order_api.repository;

import com.example.dine_in_order_api.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
