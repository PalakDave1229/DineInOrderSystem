package com.example.dine_in_order_api.mapper;

import com.example.dine_in_order_api.dto.request.FoodItemRequest;
import com.example.dine_in_order_api.dto.responce.CuisineTypeResponse;
import com.example.dine_in_order_api.dto.responce.FoodItemResponse;
import com.example.dine_in_order_api.model.Category;
import com.example.dine_in_order_api.model.CuisineType;
import com.example.dine_in_order_api.model.FoodItem;
import com.example.dine_in_order_api.model.Image;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface FoodItemMapper {
    public FoodItem mapToFoodItem(FoodItemRequest foodItemRequest);
    public FoodItemResponse mappToFoodItemResponse (FoodItem foodItem);
    public List<FoodItemResponse> mapToListOfFoodItemResponse(List<FoodItem> foodItems);
    List<String> map(List<Image> value);
    default String map(Image value){
        if(value != null){
            return value.getImageURL();
        }
        else return null;
    }
    default CuisineTypeResponse mapToCuisineTypeResponse(CuisineType value){
        if(value == null) {
            return null;
        }
        else {
            CuisineTypeResponse type = new CuisineTypeResponse();
            type.setCuisine(value.getCuisine().toLowerCase());
            return type;
        }
    };
    default String mapToString(CuisineType value) {
        if(value == null) {
            return null;
        }
        else return value.getCuisine().toLowerCase();
    }

    default String mapToString(Category value) {
        if(value == null) {
            return null;
        }
        else return value.getCategory().toLowerCase();
    }

    default CuisineType mapToCuisineType(String value) {
        if(value == null) {
            return null;
        }
        else {
            CuisineType type = new CuisineType();
            type.setCuisine(value.toLowerCase());
            return type;
        }
    }
    default Category mapToCategory(String value) {
        if(value == null) {
            return null;
        }
        else {
            Category type = new Category();
            type.setCategory(value.toLowerCase());
            return type;
        }
    }
}
