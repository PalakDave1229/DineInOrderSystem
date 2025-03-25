package com.example.dine_in_order_api.exception;

public class InvaildJWTException extends RuntimeException {
    private String message;
    public InvaildJWTException(String message) {
        this.message = message;
    }
}
