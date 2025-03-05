package com.example.dine_in_order_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Table(name = "CuisineType")
public class CuisineType {

    @Id
    @Column(name = "cuisine")
    private String cuisine;

    @ManyToMany
    private List<Restaurent> restaurent;

}
