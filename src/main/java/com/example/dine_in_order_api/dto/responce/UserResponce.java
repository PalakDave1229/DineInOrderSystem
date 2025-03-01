package com.example.dine_in_order_api.dto.responce;

import com.example.dine_in_order_api.enums.UserRole;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class UserResponce {
    private long userid;
    private String username;
    private UserRole userrole;
    private LocalDate createdat;
    private LocalDateTime lastmodifiedat;
}
