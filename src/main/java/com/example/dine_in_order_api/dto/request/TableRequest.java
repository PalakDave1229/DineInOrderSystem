package com.example.dine_in_order_api.dto.request;

import com.example.dine_in_order_api.enums.TableStatus;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TableRequest {

    @NotBlank(message = "table number can not be null or blank !!")
    @Column(name = "table_number" , unique = true)
    private String tableNumber;

    @NotBlank(message = "number of capacity can not be null or blank !!")
    private int tableCapacity;

}
