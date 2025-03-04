package com.example.dine_in_order_api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    @NotEmpty(message = "Username can not be null or blank !! ")
    private String username;
    private String email;
    private String phno;
}
