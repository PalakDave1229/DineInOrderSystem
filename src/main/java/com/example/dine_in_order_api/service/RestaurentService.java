package com.example.dine_in_order_api.service;

import com.example.dine_in_order_api.dto.request.RestaurantRequest;
import com.example.dine_in_order_api.dto.responce.RestaurestResponse;

public interface RestaurentService {
    public RestaurestResponse createRestaurant(RestaurantRequest restaurantRequest);
    public RestaurestResponse updateRestaurant(RestaurantRequest restaurantRequest,Long restaurantId);

}