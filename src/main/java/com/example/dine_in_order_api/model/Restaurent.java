package com.example.dine_in_order_api.model;

import com.example.dine_in_order_api.enums.DietType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Restaurent")
@EntityListeners(AuditingEntityListener.class)
public class Restaurent {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private long restaurantId;

    @Column(name = "restaurant_name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "Phone_no")
    private String contactNumber;

    @Column(name = "email")
    private String contactEmail;

    @Column(name = "open_at")
    private LocalTime opensAt;

    @Column(name = "close_at")
    private LocalTime closeAt;

    @Enumerated
    @Column(name = "diet_type")
    private List<DietType> dietTypes;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDate createdAt;

    @LastModifiedDate
    @Column(name = "last_modified_at")
    private LocalDateTime lastModifiedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private Admin admin;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<CuisineType> cuisineTypes;

    @OneToMany(mappedBy = "restaurent")
    private List<RestaurantTable> restaurantTables;

    @OneToMany(mappedBy = "restaurent")
    private List<FoodItem> foodItems;

    @OneToMany(mappedBy = "restaurent")
    private List<Staff> staffs;
}
