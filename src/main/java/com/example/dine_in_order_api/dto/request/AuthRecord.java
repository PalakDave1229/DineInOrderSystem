package com.example.dine_in_order_api.dto.request;

import com.example.dine_in_order_api.enums.UserRole;

public record AuthRecord(
   long userId,
   String name,
   String email,
   UserRole userRole,
   long accessExpiration,
   long refereshExpiration
){}
