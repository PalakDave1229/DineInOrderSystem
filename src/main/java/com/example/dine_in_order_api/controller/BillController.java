package com.example.dine_in_order_api.controller;

import com.example.dine_in_order_api.dto.responce.BillResponse;
import com.example.dine_in_order_api.service.BillService;
import com.example.dine_in_order_api.utility.ResponseBuilder;
import com.example.dine_in_order_api.utility.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${app.base-url}")
@AllArgsConstructor
public class BillController {

    private final BillService billService;

    @PostMapping("/bills/tables/{tableId}")
    public ResponseEntity<ResponseStructure<BillResponse>> createBill(@PathVariable long tableId){
        BillResponse billResponse = billService.createBill(tableId);
        return ResponseBuilder.created(billResponse,"Bill Generated !!");
    }

    @GetMapping("/bills/{billId}")
    public ResponseEntity<ResponseStructure<BillResponse>> findByBillId(@PathVariable long billId){
        BillResponse billResponse = billService.findById(billId);
        return ResponseBuilder.ok(billResponse,"Bill Found !!");
    }

    @GetMapping("/bills/pdf/{billId}")
    public ResponseEntity<ResponseStructure<Byte[]>> findBillById(@PathVariable long billId){
        BillResponse billResponse = billService.findById(billId);
        ResponseBuilder.ok(billResponse,"Bill Found !!");
        return null;
    }

}
