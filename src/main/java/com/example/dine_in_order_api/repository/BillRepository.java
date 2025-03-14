package com.example.dine_in_order_api.repository;


import com.example.dine_in_order_api.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill,Long> {
}
