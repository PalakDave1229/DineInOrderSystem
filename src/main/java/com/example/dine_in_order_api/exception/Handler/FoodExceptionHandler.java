package com.example.dine_in_order_api.exception.Handler;

import com.example.dine_in_order_api.exception.FoodNotFoundException;
import com.example.dine_in_order_api.utility.ResponseBuilder;
import com.example.dine_in_order_api.utility.SimpleErrorStructure;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FoodExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<SimpleErrorStructure> RestaurantNotFoundException(FoodNotFoundException e){
        return ResponseBuilder.notFound(e.getMessage());
    }
}
