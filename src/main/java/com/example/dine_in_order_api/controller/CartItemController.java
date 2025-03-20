package com.example.dine_in_order_api.controller;

import com.example.dine_in_order_api.dto.responce.CartItemResponse;
import com.example.dine_in_order_api.service.CartItemService;
import com.example.dine_in_order_api.utility.ResponseBuilder;
import com.example.dine_in_order_api.utility.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${app.base-url}")
@AllArgsConstructor
public class CartItemController {

    private final CartItemService cartItemService;

    @PostMapping("/tables/{tableid}/cart-items/food-items/{foodid}")
    public ResponseEntity<ResponseStructure<CartItemResponse>> createCartItem(@PathVariable long tableid,
                                                                              @PathVariable long foodid ,
                                                                              @RequestParam int quantity){
        return ResponseBuilder.created(cartItemService.createCartItem(tableid,foodid,quantity),"Cart item created");
    }

    @PatchMapping("/cart-items/{cartId}")
    public ResponseEntity<ResponseStructure<CartItemResponse>> updateQuantity(@PathVariable long cartId,@RequestParam int quantity){
        return ResponseBuilder.ok(cartItemService.updateQuantity(cartId,quantity),"cart quantity updated");
    }

}
