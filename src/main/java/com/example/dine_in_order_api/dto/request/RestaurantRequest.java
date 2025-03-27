package com.example.dine_in_order_api.dto.request;

import com.example.dine_in_order_api.dto.constraints.Email;
import com.example.dine_in_order_api.dto.constraints.MinValue;
import com.example.dine_in_order_api.dto.constraints.Names;
import com.example.dine_in_order_api.dto.constraints.PhoneNo;
import com.example.dine_in_order_api.enums.DietType;
import jakarta.validation.Valid;
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

    @PhoneNo
    private String contactNumber;

    @Email
    private String contactEmail;

    @NotNull(message = "open timing can not be null !!")
    private LocalTime opensAt;

    @NotNull(message = "close timing can not be null !!")
    private LocalTime closeAt;

    @NotEmpty(message = "Diet types cannot be empty !!")
    @Valid
    private List<@NotNull(message = "Diet type cannot be null !!") DietType> dietTypes;

    @NotEmpty(message = "Cuisine types cannot be empty !!")
    @Valid
    private List<@NotBlank(message = "Cuisine type cannot be blank !!") String> cuisineTypes;
}
