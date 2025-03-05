package com.example.dine_in_order_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

public class CuisineType {

    @ManyToMany
    private Restaurent restaurent;

    @Id
    @Column(name = "cuisine_name")
    private String cuisineName;
}
