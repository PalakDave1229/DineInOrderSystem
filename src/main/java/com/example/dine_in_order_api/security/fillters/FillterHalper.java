package com.example.dine_in_order_api.security.fillters;

import com.example.dine_in_order_api.security.jwt.TokenType;
import jakarta.servlet.http.Cookie;

public class FillterHalper {
    public static String extractToken(TokenType tokenType, Cookie[] cookies){
        String token = null;
        if(cookies != null){
        for(Cookie cookie : cookies){
            if(cookie.getName().equals(tokenType.type())) {
                token = cookie.getValue();
                break;
            }
        }}
        else {
            return null;
        }
        return token;
    }
}
