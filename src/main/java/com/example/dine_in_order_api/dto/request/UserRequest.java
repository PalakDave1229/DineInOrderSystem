package com.example.dine_in_order_api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    @NotEmpty(message = "Username can not be null or blank !! ")
    @NotBlank(message = "Username can not be blank !!")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$" , message = "User can only contain Alphabets , Number and UnderScore")
    private String username;

    @NotEmpty(message = "Email can not be null or blank !!")
    @NotBlank(message = "Username can not be blank !!")
    @Email(regexp = "^[a-zA-Z0-9._%+-]+@gmail.com", message = "Email must be a valid Gmail address")
    private String email;

    @Pattern(regexp = "^[7-9]\\d{9}$", message = "Invalid Phone Number")
    private String phno;
}
