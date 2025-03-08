package com.example.dine_in_order_api.controller;

import com.example.dine_in_order_api.dto.request.TableRequest;
import com.example.dine_in_order_api.dto.responce.TableResponce;
import com.example.dine_in_order_api.model.RestaurantTable;
import com.example.dine_in_order_api.service.TableService;
import com.example.dine_in_order_api.utility.ResponseBuilder;
import com.example.dine_in_order_api.utility.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("${app.base-url}")
public class TableController {

    private final TableService tableService;

    @PostMapping("/tables/restaurant/{id}")
    public ResponseEntity<ResponseStructure<TableResponce>> createTable(@PathVariable long id , @RequestBody TableRequest tableRequest){

        TableResponce tableResponce =  tableService.createTable(id,tableRequest);

      return ResponseBuilder.created(tableResponce,"Table created");
    }
}
