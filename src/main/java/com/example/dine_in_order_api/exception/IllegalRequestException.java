package com.example.dine_in_order_api.exception;

public class IllegalRequestException extends RuntimeException {
    String message;
    public IllegalRequestException(String s) {
        message = s;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
