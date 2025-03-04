package com.example.dine_in_order_api.dto.request;

import com.example.dine_in_order_api.enums.UserRole;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequest {
    @NotEmpty(message = "Username can not be null or blank !!")
    @NotBlank(message = "Username can not be blank !!")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$" , message = "User can only contain Alphabets , Number and UnderScore")
    private String username;

    @NotEmpty(message = "Email can not be null or blank !!")
    @NotBlank(message = "Username can not be blank !!")
    @Email(regexp = "^[a-zA-Z0-9._%+-]+@gmail.com", message = "Email must be a valid Gmail address")
    private String email;

    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z].*[a-z])(?=.*\\d)(?=.*[@$!%*?#&]).{8,}$",
            message = "Password must be at least 8 characters long, contain at least one uppercase letter, at least two lowercase letters, at least one digit, and at least one special character (@$!%#*?&)"
    )
    private String password;

    @Pattern(regexp = "^[7-9]\\d{9}$", message = "Invalid Phone Number")
    private String phno;

    private UserRole userrole;
}
