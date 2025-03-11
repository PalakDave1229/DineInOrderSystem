package com.example.dine_in_order_api.dto.request;

import com.example.dine_in_order_api.enums.DietType;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FoodItemRequest {
    private String name;
    private double price;
    private String Description;
    private int stock;
    private DietType dietType;
    private String cuisineType;
    private List<String> categories;
}
