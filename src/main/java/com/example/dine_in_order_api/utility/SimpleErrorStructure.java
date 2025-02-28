package com.example.dine_in_order_api.utility;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SimpleErrorStructure {
    private int code;
    private String message;
    private String type;
}
