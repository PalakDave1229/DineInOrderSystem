package com.example.dine_in_order_api.exception;

public class UserNotFoundException extends RuntimeException {
     private String message;

    public UserNotFoundException(String message) {
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
}
