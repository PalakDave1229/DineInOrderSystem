package com.example.dine_in_order_api.dto.request;

import com.example.dine_in_order_api.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequest {
    private String username;
    private String email;
    private String password;
    private String phno;
    private UserRole userrole;
}
