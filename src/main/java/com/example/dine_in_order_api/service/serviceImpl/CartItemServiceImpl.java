package com.example.dine_in_order_api.service.serviceImpl;

import com.example.dine_in_order_api.dto.responce.CartItemResponse;
import com.example.dine_in_order_api.exception.FoodNotFoundException;
import com.example.dine_in_order_api.mapper.CartItemMapper;
import com.example.dine_in_order_api.model.CartItem;
import com.example.dine_in_order_api.model.FoodItem;
import com.example.dine_in_order_api.model.RestaurantTable;
import com.example.dine_in_order_api.repository.CartItemRepository;
import com.example.dine_in_order_api.repository.FoodItemRepository;
import com.example.dine_in_order_api.repository.TableRepository;
import com.example.dine_in_order_api.service.CartItemService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.security.InvalidParameterException;

@Service
@AllArgsConstructor
public class CartItemServiceImpl implements CartItemService {

    private final CartItemMapper cartItemMapper;
    private final TableRepository tableRepository;
    private final FoodItemRepository foodItemRepository;
    private final CartItemRepository cartItemRepository;

    @Override
    public CartItemResponse createCartItem(long tableId, long foodId, int quantity) {

        RestaurantTable restaurantTable = tableRepository.findById(tableId)
                .orElseThrow(() -> new InvalidParameterException("Table Not Found !!"));

        FoodItem foodItem = foodItemRepository.findById(foodId)
                .orElseThrow(() -> new FoodNotFoundException("Food Not Found To Add In Cart"));

        CartItem cartItem;

        if (foodItem.getRestaurent().getRestaurantId() != restaurantTable.getRestaurent().getRestaurantId() ) {
            throw new FoodNotFoundException("food item not found in restaurant !!");
        }
        else if (foodItem.getStock() < quantity) {
            try {
                throw new AccessDeniedException("not enough stock is available : current stock = "+foodItem.getStock());
            } catch (AccessDeniedException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            cartItem = cartItemRepository.save(
                    getCartItem(quantity, foodItem, restaurantTable));
        }
        return cartItemMapper.mapToCartItemResponse(cartItem);
    }

    @Override
    public CartItemResponse updateQuantity(long cartId, int quantity) {

        CartItem cartItem = cartItemRepository.findById(cartId)
                .orElseThrow(() -> new EntityNotFoundException("Cart item with ID " + cartId + " not found"));
        if(!cartItem.isOrdered()) {
            cartItem.setQuantity(quantity);
            cartItem.setTotalPrice(cartItem.getFoodItem().getPrice() * quantity);
        }
        else{
            try {
                throw new AccessDeniedException("Can't update quantity after ordered!! , you can do new order for more items :) " );
            } catch (AccessDeniedException e) {
                throw new RuntimeException(e);
            }
        }
        return cartItemMapper.mapToCartItemResponse(
                cartItemRepository.save(cartItem)
        );
    }

    private static CartItem getCartItem(int quantity, FoodItem foodItem, RestaurantTable restaurantTable) {
        CartItem cartItem = new CartItem();
        cartItem.setFoodItem(foodItem);
        cartItem.setQuantity(quantity);
        cartItem.setTotalPrice(foodItem.getPrice() * quantity);
        cartItem.setRestaurantTable(restaurantTable);
        cartItem.setOrdered(false);
        return cartItem;
    }

}
