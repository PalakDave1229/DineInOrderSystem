package com.example.dine_in_order_api.controller;

import com.example.dine_in_order_api.dto.request.RestaurantRequest;
import com.example.dine_in_order_api.dto.responce.RestaurestResponse;
import com.example.dine_in_order_api.service.RestaurentService;
import com.example.dine_in_order_api.utility.ResponseBuilder;
import com.example.dine_in_order_api.utility.ResponseStructure;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("${app.base-url}")
public class RestaurantController {

    private RestaurentService restaurentService;

    @PostMapping("/Restaurant/{userId}")
    public ResponseEntity<ResponseStructure<RestaurestResponse>> createRestaurant(
            @PathVariable long userId, @RequestBody RestaurantRequest restaurantRequest){

        RestaurestResponse restaurestResponse =
                restaurentService.createRestaurant(userId,restaurantRequest);

        return ResponseBuilder.created(
                restaurestResponse, "Restaurant Added successfully !! ");
    }

}
