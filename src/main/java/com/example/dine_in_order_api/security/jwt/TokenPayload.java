package com.example.dine_in_order_api.security.jwt;

import java.util.Map;

public record TokenPayload(
   Map<String,Object> claims,
   long issueAt,
   long expiration
) {}
