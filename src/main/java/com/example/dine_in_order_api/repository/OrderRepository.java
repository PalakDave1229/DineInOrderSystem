package com.example.dine_in_order_api.repository;

import com.example.dine_in_order_api.enums.OrderStatus;
import com.example.dine_in_order_api.model.CartItem;
import com.example.dine_in_order_api.model.Order;
import com.example.dine_in_order_api.model.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {

    @Query("SELECT o FROM Order o WHERE "+
                                        "o.restaurantTable = :table AND o.orderStatus <> :status")
    List<Order> findByRestaurantTable(@Param("table") RestaurantTable table,
                                      @Param("status") OrderStatus status);

    Order findRestaurantTableByOrderId(long id);

}
