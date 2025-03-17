package com.example.dine_in_order_api.mapper;

import com.example.dine_in_order_api.dto.responce.BillResponse;
import com.example.dine_in_order_api.model.Bill;
import com.example.dine_in_order_api.model.Category;
import com.example.dine_in_order_api.model.CuisineType;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface BillMapper {
    public BillResponse mapToBillResponse(Bill bill);
    List<String> map(List<Category> value);
    default String mapToString(Category value) {
        if(value == null) {
            return null;
        }
        else return value.getCategory().toLowerCase();
    }
    default String mapToString(CuisineType value) {
        if(value == null) {
            return null;
        }
        else return value.getCuisine().toLowerCase();
    }
}
