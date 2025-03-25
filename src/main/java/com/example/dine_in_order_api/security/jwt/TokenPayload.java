package com.example.dine_in_order_api.security.jwt;

import java.time.Instant;
import java.util.Map;

public record TokenPayload(
   Map<String,Object> claims,
   Instant issueAt,
   Instant expiration
) {}
