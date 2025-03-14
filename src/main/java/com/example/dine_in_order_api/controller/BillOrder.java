package com.example.dine_in_order_api.controller;

import com.example.dine_in_order_api.dto.responce.BillResponse;
import com.example.dine_in_order_api.service.BillService;
import com.example.dine_in_order_api.utility.ResponseBuilder;
import com.example.dine_in_order_api.utility.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${app.base-url}")
@AllArgsConstructor
public class BillOrder {

    private final BillService billService;

    @PostMapping("/bills/tables/{tableId}")
    public ResponseEntity<ResponseStructure<BillResponse>> createBill(@PathVariable long tableId){
        BillResponse billResponse = billService.createBill(tableId);
        return ResponseBuilder.created(billResponse,"Bill Generated !!");
    }
}
