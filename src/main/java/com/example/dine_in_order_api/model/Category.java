package com.example.dine_in_order_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "category")
    private String category;

    @ManyToMany(mappedBy = "categories")
    private List<FoodItem> foodItems;
}
