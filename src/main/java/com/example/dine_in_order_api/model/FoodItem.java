package com.example.dine_in_order_api.model;

import com.example.dine_in_order_api.enums.DietType;
import com.example.dine_in_order_api.enums.StockStatus;
import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "FoodItem")
public class FoodItem {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @Column(name ="name")
    private String name;

    @Column(name ="price")
    private double price;

    @Column(name = "description")
    private String Description;

    @Column(name ="stock")
    private int stock;

    @Column(name = "availability")
    private StockStatus availability;

    @Column(name = "diet_type")
    @Enumerated
    private DietType dietType;

    @Column(name = "created_at")
    private LocalDate createdat;

    @Column(name = "last_modified_at")
    private LocalDateTime lastmodifiedat;

    @ManyToOne
    private CuisineType cuisineType;

    @ManyToOne
    private Restaurent restaurent;

}
