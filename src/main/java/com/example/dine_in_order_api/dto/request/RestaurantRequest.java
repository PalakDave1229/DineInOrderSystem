package com.example.dine_in_order_api.dto.request;

import com.example.dine_in_order_api.dto.constraints.Email;
import com.example.dine_in_order_api.dto.constraints.MinValue;
import com.example.dine_in_order_api.dto.constraints.Names;
import com.example.dine_in_order_api.dto.constraints.PhoneNo;
import com.example.dine_in_order_api.enums.DietType;
import jakarta.validation.constraints.*;
import jdk.jfr.Name;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class RestaurantRequest {

    @NotNull(message = "Restaurant can not be null !!")
    @NotBlank(message = "Restaurant can not be blank !!")
    @Names
    private String name;

    @MinValue
    @NotBlank
    private String address;

    private String contactNumber;

    @Email
    private String contactEmail;

    @NotNull(message = "Restaurant can not be null !!")
    private LocalTime opensAt;

    @NotNull(message = "Restaurant can not be null !!")
    private LocalTime closeAt;

    private List<DietType> dietTypes;
    private List<String> cuisineTypes;
}
