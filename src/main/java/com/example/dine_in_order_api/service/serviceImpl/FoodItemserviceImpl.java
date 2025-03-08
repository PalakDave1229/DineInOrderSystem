package com.example.dine_in_order_api.service.serviceImpl;

import com.example.dine_in_order_api.dto.request.FoodItemRequest;
import com.example.dine_in_order_api.dto.responce.FoodItemResponse;
import com.example.dine_in_order_api.exception.RestaurantNotFoundException;
import com.example.dine_in_order_api.mapper.FoodItemMapper;
import com.example.dine_in_order_api.model.CuisineType;
import com.example.dine_in_order_api.model.FoodItem;
import com.example.dine_in_order_api.model.Restaurent;
import com.example.dine_in_order_api.repository.CuisineRepository;
import com.example.dine_in_order_api.repository.FoodItemRepository;
import com.example.dine_in_order_api.repository.RestaurentRepository;
import com.example.dine_in_order_api.service.FoodItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@AllArgsConstructor
@Service
public class FoodItemserviceImpl implements FoodItemService {

    private final RestaurentRepository restaurentRepository;
    private final FoodItemRepository foodItemRepository;
    private final FoodItemMapper foodItemMapper;
    private final CuisineRepository cuisineRepository;

    @Override
    @Transactional
    public FoodItemResponse createFoodItem(long id, FoodItemRequest foodItemRequest) {

        FoodItem foodItem = foodItemMapper.mapToFoodItem(foodItemRequest);

        Restaurent restaurent = restaurentRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found !!"));

        cuisineRepository.findById(foodItem.getCuisineType().getCuisine())
                .orElseGet(() -> {
                    CuisineType cuisineType = cuisineRepository.save(foodItem.getCuisineType());
                    restaurent.getCuisineTypes().add(cuisineType);
                    restaurentRepository.save(restaurent);
                    return cuisineType;
                });

        foodItem.setRestaurent(restaurent);
        foodItem.setCuisineType(foodItem.getCuisineType());

        foodItemRepository.save(foodItem);

        return foodItemMapper.mappToFoodItemResponse(foodItem);
    }
}
