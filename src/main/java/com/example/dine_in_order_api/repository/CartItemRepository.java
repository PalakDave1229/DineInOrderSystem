package com.example.dine_in_order_api.repository;

import com.example.dine_in_order_api.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long>{
}
