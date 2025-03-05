package com.example.dine_in_order_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "CuisineType")
public class CuisineType {

    @ManyToMany
    private Restaurent restaurent;

    @Id
    @Column(name = "cuisine")
    private String cuisine;
}
