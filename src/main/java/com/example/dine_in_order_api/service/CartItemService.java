package com.example.dine_in_order_api.service;

import com.example.dine_in_order_api.dto.responce.CartItemResponse;

public interface CartItemService {
    public CartItemResponse createCartItem(long tableId, long foodId,int quantity);

    public CartItemResponse updateQuantity(long cartId, int quantity);
}
