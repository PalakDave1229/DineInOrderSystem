package com.example.dine_in_order_api.dto.request;

import com.example.dine_in_order_api.dto.constraints.Email;
import com.example.dine_in_order_api.dto.constraints.Password;

public record LoginRequest(
   @Email
   String email,
   @Password
   String password
) {}
