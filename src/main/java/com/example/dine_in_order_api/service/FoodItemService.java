package com.example.dine_in_order_api.service;

import com.example.dine_in_order_api.dto.request.FoodItemRequest;
import com.example.dine_in_order_api.dto.responce.FoodItemResponse;


public interface FoodItemService {
    public FoodItemResponse createFoodItem(long id , FoodItemRequest foodItemRequest);
}
