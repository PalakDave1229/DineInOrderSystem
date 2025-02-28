package com.example.dine_in_order_api.service;

import com.example.dine_in_order_api.dto.request.RegistrationRequest;
import com.example.dine_in_order_api.dto.request.UserRequest;
import com.example.dine_in_order_api.dto.responce.UserResponce;

public interface UserService {
    public UserResponce registration(RegistrationRequest registrationRequest);
    public UserResponce findById(Long id);
    public UserResponce updateById(UserRequest user, Long userId);
}