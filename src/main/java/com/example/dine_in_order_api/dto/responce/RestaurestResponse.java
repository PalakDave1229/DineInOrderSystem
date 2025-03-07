package com.example.dine_in_order_api.dto.responce;

import com.example.dine_in_order_api.enums.DietType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class RestaurestResponse {
    private Long restaurantId;
    private String name;
    private String address;
    private String contactNumber;
    private String contactEmail;
    private LocalDateTime opensAt;
    private LocalDateTime closeAt;
    private List<DietType> dietTypes;
    private LocalDateTime lastModifiedAt;
    private LocalDate createdAt;
    private List<String> cuisineTypes;
}
