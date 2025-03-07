package com.example.dine_in_order_api.exception.Handler;

import com.example.dine_in_order_api.exception.UserNotFoundException;
import com.example.dine_in_order_api.utility.ResponseBuilder;
import com.example.dine_in_order_api.utility.SimpleErrorStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class UserApplicationHandler{

    @ExceptionHandler
    public ResponseEntity<SimpleErrorStructure> handleUserNotFoundError(UserNotFoundException e){
        return ResponseBuilder.notFound(e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<SimpleErrorStructure> handleAccessDeniedException(AccessDeniedException e){
        return ResponseBuilder.notFound(e.getMessage());
    }


}
