package com.example.dine_in_order_api.controller;

import com.example.dine_in_order_api.dto.responce.BillResponse;
import com.example.dine_in_order_api.service.BillService;
import com.example.dine_in_order_api.utility.ResponseBuilder;
import com.example.dine_in_order_api.utility.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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
    public ResponseEntity<byte[]> findBillById(@PathVariable long billId) throws IOException {

        byte[] billPDF = billService.pdfGenerator(billId);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Dine-in-bill.pdf")
                .body(billPDF);

    /*
        for httpServletResponse :-
                response.setContentType("application/pdf");
                response.setHeader("Content-Disposition", "attachment; filename=zomato-bill.pdf");
                response.getOutputStream().write(pdfBytes);  */
    }
}
