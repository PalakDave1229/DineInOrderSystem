package com.example.dine_in_order_api.service;

import com.example.dine_in_order_api.dto.request.RegistrationRequest;
import com.example.dine_in_order_api.dto.responce.UserResponce;
import com.example.dine_in_order_api.model.User;

public interface UserService {
    public UserResponce registration(RegistrationRequest registrationRequest);
    public UserResponce findById(Long id);
    public UserResponce updateById(User user, Long userId);
}