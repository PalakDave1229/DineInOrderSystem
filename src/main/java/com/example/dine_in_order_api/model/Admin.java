package com.example.dine_in_order_api.model;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name="admins")
@Getter
@Setter
public class Admin extends User{
    @OneToMany(mappedBy = "admin")
    private Restaurent restaurent;
}
