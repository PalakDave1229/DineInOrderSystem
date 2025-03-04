package com.example.dine_in_order_api.utility;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class SimpleErrorStructure {
    private int code;
    private String message;
    private String type;
}
