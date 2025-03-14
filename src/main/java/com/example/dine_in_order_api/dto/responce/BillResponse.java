package com.example.dine_in_order_api.dto.responce;

import com.example.dine_in_order_api.model.Order;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class BillResponse {

    private long billId;
    private LocalDateTime generatedAt;
    private double totalPayableAmount;
    private List<Order> orders;

}
