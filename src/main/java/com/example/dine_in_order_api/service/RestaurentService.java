package com.example.dine_in_order_api.service;

import com.example.dine_in_order_api.dto.request.RestaurantRequest;
import com.example.dine_in_order_api.dto.responce.RestaurestResponse;

public interface RestaurentService {
    public RestaurestResponse createRestaurant(long userId, RestaurantRequest restaurantRequest);
}
