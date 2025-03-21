package com.example.dine_in_order_api.security.jwt;

public enum TokenType {
    ACCESS("at"),REFRESH("rt");

    private final String type;

    TokenType(String type) {
        this.type = type;
    }

    public String type(){
        return this.type;
    }

}
