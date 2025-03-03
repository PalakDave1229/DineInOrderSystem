package com.example.dine_in_order_api.dto.request;

import com.example.dine_in_order_api.enums.UserRole;
import com.example.dine_in_order_api.exception.UserNotFoundException;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequest {
    @NotEmpty(message = "Username can not be null or blank !!")
    @NotBlank(message = "Username can not be blank !!")
    private String username;
    @NotEmpty(message = "Email can not be null or blank !!")
    @NotBlank(message = "Username can not be blank !!")
    private String email;
    private String password;
    private String phno;
    private UserRole userrole;
}
