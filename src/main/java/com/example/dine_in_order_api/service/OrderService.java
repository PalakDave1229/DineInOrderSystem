package com.example.dine_in_order_api.service;

import com.example.dine_in_order_api.dto.responce.OrderResponse;

public interface OrderService {
    public OrderResponse createOrder(long tableId);
}
