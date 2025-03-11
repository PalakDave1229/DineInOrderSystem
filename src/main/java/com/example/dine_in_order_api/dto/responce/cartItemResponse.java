package com.example.dine_in_order_api.dto.responce;

import com.example.dine_in_order_api.model.FoodItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class cartItemResponse {
    private long itemId;
    private FoodItem foodItem;
    private int quantity;
    private double totalPrice;
}
