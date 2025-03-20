package com.example.dine_in_order_api.dto.request;

import com.example.dine_in_order_api.dto.constraints.Email;
import com.example.dine_in_order_api.dto.constraints.MinValue;
import com.example.dine_in_order_api.dto.constraints.Names;
import com.example.dine_in_order_api.dto.constraints.PhoneNo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    @NotBlank(message = "can not be blank !!")
    @MinValue
    @Names
    private String username;

    @NotEmpty(message = "can not be null or blank !!")
    @NotBlank(message = "can not be blank !!")
    private String email;

    @PhoneNo
    private String phno;
}
