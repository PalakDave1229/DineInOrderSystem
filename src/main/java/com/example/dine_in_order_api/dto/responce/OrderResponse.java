package com.example.dine_in_order_api.dto.responce;

import com.example.dine_in_order_api.enums.OrderStatus;
import com.example.dine_in_order_api.model.CartItem;
import com.example.dine_in_order_api.repository.CartItemRepository;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderResponse {

    private long orderId;
    private OrderStatus orderStatus;
    private LocalDateTime orderedAt;
    private double totalAmount;
    private List<CartItemRepository> cartItems;

}
