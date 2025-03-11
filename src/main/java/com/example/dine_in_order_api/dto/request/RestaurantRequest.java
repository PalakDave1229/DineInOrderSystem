package com.example.dine_in_order_api.dto.request;

import com.example.dine_in_order_api.enums.DietType;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class RestaurantRequest {

    @NotNull(message = "Restaurant can not be null !!")
    @NotBlank(message = "Restaurant can not be blank !!")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$" , message = "User can only contain Alphabets , Number and UnderScore")
    private String name;

    @NotNull(message = "Restaurant can not be null !!")
    @NotBlank(message = "Restaurant can not be blank !!")
    private String address;

    @Pattern(regexp = "^[7-9]\\d{9}$", message = "Invalid Phone Number")
    private String contactNumber;

    @Email(regexp = "^[a-zA-Z0-9._%+-]+@gmail.com", message = "Email must be a valid Gmail address")
    private String contactEmail;

//    @NotNull(message = "Restaurant can not be null !!")
//    @NotBlank(message = "Restaurant can not be blank !!")
    @Pattern(regexp = "^([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$", message ="time should in proper format EX: 12:45:00 ")
    private LocalTime opensAt;

//  @NotNull(message = "Restaurant can not be null !!")
//  @NotBlank(message = "Restaurant can not be blank !!")
    @Pattern(regexp = "^([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$", message ="time should in proper format EX: 12:45:00 ")
    private LocalTime closeAt;

    private List<DietType> dietTypes;
    private List<String> cuisineTypes;
}
