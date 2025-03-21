package com.example.dine_in_order_api.service;

import com.example.dine_in_order_api.dto.request.AuthRecord;
import com.example.dine_in_order_api.dto.request.LoginRequest;

public interface AuthService {
    AuthRecord login(LoginRequest loginRequest);
}
