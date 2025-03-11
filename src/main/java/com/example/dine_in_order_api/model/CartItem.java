package com.example.dine_in_order_api.model;

import com.example.dine_in_order_api.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name ="cart_item")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long itemId;

    private int quantity;

    private double totalPrice;

    private OrderStatus isOrdered;

    @ManyToOne
    private FoodItem foodItem;

    @ManyToOne
    private RestaurantTable restaurantTable;

}
