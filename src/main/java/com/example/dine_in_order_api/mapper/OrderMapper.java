package com.example.dine_in_order_api.mapper;

import com.example.dine_in_order_api.dto.responce.OrderResponse;
import com.example.dine_in_order_api.model.Category;
import com.example.dine_in_order_api.model.Order;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface OrderMapper {
    public OrderResponse mapToOrderResponse(Order order);
    List<String> map(List<Category> value);
    default String mapToString(Category value) {
        if(value == null) {
            return null;
        }
        else return value.getCategory().toLowerCase();
    }
}
