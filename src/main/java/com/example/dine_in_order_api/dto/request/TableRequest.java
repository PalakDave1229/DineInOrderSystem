package com.example.dine_in_order_api.dto.request;

import com.example.dine_in_order_api.enums.TableStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TableRequest {
    private String tableNumber;
    private int tableCapacity;
}
