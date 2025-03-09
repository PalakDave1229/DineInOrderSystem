package com.example.dine_in_order_api.repository;

import com.example.dine_in_order_api.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodItemRepository extends JpaRepository<FoodItem,Long> {
}
