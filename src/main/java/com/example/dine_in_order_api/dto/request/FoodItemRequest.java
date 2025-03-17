package com.example.dine_in_order_api.dto.request;

import com.example.dine_in_order_api.enums.DietType;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FoodItemRequest {
    private String name;

    private double price;

    private String description;

    private int stock;

    @Pattern(regexp = "^(VEG|NON_VEG|VEGAN)$", message = "Diet type must be either 'VEG' or 'NON_VEG' or 'VEGAN'")
    private DietType dietType;

    private String cuisineType;

    private List<String> categories;
}
