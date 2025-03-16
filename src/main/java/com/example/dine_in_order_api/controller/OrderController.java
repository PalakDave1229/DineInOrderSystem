package com.example.dine_in_order_api.controller;


import com.example.dine_in_order_api.dto.responce.OrderResponse;
import com.example.dine_in_order_api.model.Order;
import com.example.dine_in_order_api.service.OrderService;
import com.example.dine_in_order_api.utility.ResponseBuilder;
import com.example.dine_in_order_api.utility.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${app.base-url}")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/orders/tables/{tableId}")
    public ResponseEntity<ResponseStructure<OrderResponse>> createOrder(@PathVariable long tableId){
        OrderResponse orderResponse = orderService.createOrder(tableId);
        return ResponseBuilder.created(orderResponse,"Order Created!! ");
    }
}
