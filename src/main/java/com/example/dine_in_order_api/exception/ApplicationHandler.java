package com.example.dine_in_order_api.exception;

import com.example.dine_in_order_api.utility.ResponseBuilder;
import com.example.dine_in_order_api.utility.SimpleErrorStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationHandler{

    @ExceptionHandler
    public ResponseEntity<SimpleErrorStructure> setUserNotFoundError(UserNotFoundException e){
        return ResponseBuilder.simpleError(e.getMessage(), HttpStatus.NOT_FOUND);
    }

}
