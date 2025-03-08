package com.example.dine_in_order_api.dto.responce;

import com.example.dine_in_order_api.enums.TableStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TableResponce {

    private long id;
    private String tableNumber;
    private int tableCapacity;
    private TableStatus status;

}
