package com.example.dine_in_order_api.service;

import com.example.dine_in_order_api.dto.request.TableRequest;
import com.example.dine_in_order_api.dto.responce.TableResponce;
import org.springframework.stereotype.Service;


public interface TableService {
    public TableResponce   createTable(long restaurantId, TableRequest tableRequest);
}
