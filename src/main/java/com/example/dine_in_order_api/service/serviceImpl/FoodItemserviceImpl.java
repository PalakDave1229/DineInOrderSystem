package com.example.dine_in_order_api.service.serviceImpl;

import com.example.dine_in_order_api.dto.request.FoodItemRequest;
import com.example.dine_in_order_api.dto.responce.FoodItemResponse;
import com.example.dine_in_order_api.exception.FoodNotFoundException;
import com.example.dine_in_order_api.exception.RestaurantNotFoundException;
import com.example.dine_in_order_api.mapper.FoodItemMapper;
import com.example.dine_in_order_api.model.Category;
import com.example.dine_in_order_api.model.CuisineType;
import com.example.dine_in_order_api.model.FoodItem;
import com.example.dine_in_order_api.model.Restaurent;
import com.example.dine_in_order_api.repository.CategoryRepository;
import com.example.dine_in_order_api.repository.CuisineRepository;
import com.example.dine_in_order_api.repository.FoodItemRepository;
import com.example.dine_in_order_api.repository.RestaurentRepository;
import com.example.dine_in_order_api.service.FoodItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;


@AllArgsConstructor
@Service
public class FoodItemserviceImpl implements FoodItemService {

    private final RestaurentRepository restaurentRepository;
    private final FoodItemRepository foodItemRepository;
    private final FoodItemMapper foodItemMapper;
    private final CuisineRepository cuisineRepository;
    private final CategoryRepository categoryRepository;

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

        foodItem.setCategories(this.createNonExistingCategory(foodItem.getCategories()));
        foodItem.setRestaurent(restaurent);
        foodItem.setCuisineType(foodItem.getCuisineType());

        foodItemRepository.save(foodItem);

        return foodItemMapper.mappToFoodItemResponse(foodItem);
    }

    @Override
    public List<FoodItemResponse> findByTwoCategories(List<String> categories) {
        if(categories.isEmpty()){
            throw new FoodNotFoundException("No food with this categories");
        }
        else{
            List<FoodItemResponse> foodItemList = foodItemMapper.mapToListOfFoodItemResponse(
                    foodItemRepository.findByTwoCategories(
                            categories.stream().distinct().toList(),categories.size()));
            if(foodItemList.isEmpty()){
                throw new FoodNotFoundException("No food with this categories");
            }
            else {
                return foodItemList;
            }
        }
    }

    @Override
    public List<FoodItemResponse> findByRestaurantId(long restaurantId) {

        Restaurent restaurent = restaurentRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found !!"));

        List<FoodItem>  foodItemList = foodItemRepository.findByRestaurent(restaurent);

        if(foodItemList.isEmpty()){
            throw new FoodNotFoundException("No food with this Restaurant");
        }
        else {
            return foodItemMapper.mapToListOfFoodItemResponse(foodItemList);
        }
    }

    private List<Category> createNonExistingCategory(List<Category> categories) {
        return categories.stream()
                .map(type -> categoryRepository.findById(type.getCategory())
                        .orElseGet(() ->categoryRepository.save(type)))
                .toList();
    }

}
