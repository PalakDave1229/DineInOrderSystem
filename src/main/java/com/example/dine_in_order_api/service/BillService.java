package com.example.dine_in_order_api.service;

import com.example.dine_in_order_api.dto.responce.BillResponse;

import java.io.IOException;

public interface BillService {
    public BillResponse createBill(long tableId);

    public BillResponse findById(long billId);

    byte[] pdfGenerator(long billId) throws IOException;
}
