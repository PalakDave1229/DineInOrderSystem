package com.example.dine_in_order_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "CuisineType")
public class CuisineType {

    @Id
    @Column(name = "cuisine")
    private String cuisine;

    @ManyToMany(mappedBy = "cuisineTypes")
    private List<Restaurent> restaurents;

    @OneToMany(mappedBy = "cuisineType")
    private List<FoodItem> foodItems;

}
