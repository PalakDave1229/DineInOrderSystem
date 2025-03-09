package com.example.dine_in_order_api.mapper;

import com.example.dine_in_order_api.dto.request.FoodItemRequest;
import com.example.dine_in_order_api.dto.responce.FoodItemResponse;
import com.example.dine_in_order_api.model.CuisineType;
import com.example.dine_in_order_api.model.FoodItem;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface FoodItemMapper {
    public FoodItem mapToFoodItem(FoodItemRequest foodItemRequest);
    public FoodItemResponse mappToFoodItemResponse (FoodItem foodItem);

    default String mapToString(CuisineType value) {
        if(value == null) {
            return null;
        }
        else return value.getCuisine().toLowerCase();
    }

    default CuisineType mapToCuisineType(String value) {
        if(value == null) {
            return null;
        }
        else {
            CuisineType type = new CuisineType();
            type.setCuisine(value);
            return type;
        }
    }
}
