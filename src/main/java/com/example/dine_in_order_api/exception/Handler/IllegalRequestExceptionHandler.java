package com.example.dine_in_order_api.exception.Handler;

import com.example.dine_in_order_api.exception.IllegalRequestException;
import com.example.dine_in_order_api.utility.ResponseBuilder;
import com.example.dine_in_order_api.utility.SimpleErrorStructure;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

public class IllegalRequestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<SimpleErrorStructure> IllegalRequestException(IllegalRequestException e){
        return ResponseBuilder.notFound(e.getMessage());
    }
}
