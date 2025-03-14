package com.example.dine_in_order_api.exception.Handler;

import com.example.dine_in_order_api.exception.RestaurantNotFoundException;
import com.example.dine_in_order_api.exception.UserNotFoundException;
import com.example.dine_in_order_api.utility.ResponseBuilder;
import com.example.dine_in_order_api.utility.SimpleErrorStructure;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestaurantApplicaitonHandler {
    @ExceptionHandler(RestaurantNotFoundException.class)
    public ResponseEntity<SimpleErrorStructure> RestaurantNotFoundException(RestaurantNotFoundException e){
        return ResponseBuilder.notFound(e.getMessage());
    }

}
