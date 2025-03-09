package com.example.dine_in_order_api.repository;

import com.example.dine_in_order_api.model.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<RestaurantTable,Long>{
}
