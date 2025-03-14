package com.example.dine_in_order_api.service;

import com.example.dine_in_order_api.dto.responce.BillResponse;

public interface BillService {
    public BillResponse createBill(long tableId);

    public BillResponse findById(long billId);

    Byte[] findBillById(long billId);
}
