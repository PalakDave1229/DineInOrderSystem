package com.example.dine_in_order_api.dto.request;

import com.example.dine_in_order_api.dto.constraints.Email;
import com.example.dine_in_order_api.dto.constraints.Names;
import com.example.dine_in_order_api.dto.constraints.PhoneNo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    @Names
    private String username;

    @Email
    private String email;

    @PhoneNo
    private String phno;
}
