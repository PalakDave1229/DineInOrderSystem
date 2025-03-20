package com.example.dine_in_order_api.model;

import com.example.dine_in_order_api.enums.TableStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "RestaurantTable")
@EntityListeners(AuditingEntityListener.class)
public class RestaurantTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @CreatedBy
    private String createdBy;

    @Column(name = "table_number")
    private String tableNumber;

    @Column(name = "table_capacity")
    private int tableCapacity;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private TableStatus status;

    @ManyToOne
    private Restaurent restaurent;

    @ManyToMany(mappedBy = "restaurantTables")
    private List<Staff> staffs;

    @OneToMany(mappedBy = "restaurantTable")
    private List<CartItem> cartItems;

    @OneToMany
    private List<Order> order;
}