package com.example.dine_in_order_api.utility;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class SimpleResponseStructure {
    private int httpStatus;
    private String message;
}
