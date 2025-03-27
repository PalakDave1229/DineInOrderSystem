package com.example.dine_in_order_api.dto.request;

import com.example.dine_in_order_api.dto.constraints.*;
import com.example.dine_in_order_api.dto.constraints.Email;
import com.example.dine_in_order_api.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationRequest {
    @NotBlank(message = "Username can not be null or blank !!")
    @MinValue
    @Names
    private String username;

    @Email(message = "email is not valid")
    private String email;

    @Password
    private String password;

    @PhoneNo
    private String phno;

}
