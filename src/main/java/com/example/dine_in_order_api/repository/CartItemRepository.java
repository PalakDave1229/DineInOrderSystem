package com.example.dine_in_order_api.repository;

import com.example.dine_in_order_api.model.CartItem;
import com.example.dine_in_order_api.model.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem,Long>{

    @Query("SELECT c FROM CartItem c WHERE c.restaurantTable = :table AND c.ordered = false")
    List<CartItem> findByRestaurantTable(@Param("table") RestaurantTable table);

}
