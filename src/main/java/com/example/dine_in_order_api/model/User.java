package com.example.dine_in_order_api.model;

import com.example.dine_in_order_api.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userid;

    @Column(name = "user_name")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "ph_no")
    private String phno;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole userrole;

    @Column(name = "created_at")
    private LocalDate createdat;

    @Column(name = "last_modified_at")
    private LocalDateTime lastmodifiedat;
}
