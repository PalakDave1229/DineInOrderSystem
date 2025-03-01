package com.example.dine_in_order_api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    @NonNull()
    @NotBlank(message = "name shoud some thing not an empty space !!")
    private String username;
    private String email;
    private String phno;
}
