package com.example.dine_in_order_api.mapper;

import com.example.dine_in_order_api.dto.responce.OrderResponse;
import com.example.dine_in_order_api.model.Order;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface OrderMapper {
    public OrderResponse mapToOrderResponse(Order order);
}
