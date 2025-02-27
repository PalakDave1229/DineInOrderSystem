package com.example.dine_in_order_api.service;

import com.example.dine_in_order_api.model.User;
import com.example.dine_in_order_api.utility.ResponseStructure;
import org.springframework.http.ResponseEntity;

public interface UserService {
    public User registration(User user);
    public User findById(Long id);
}