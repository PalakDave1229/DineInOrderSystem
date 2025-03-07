package com.example.dine_in_order_api.repository;

import com.example.dine_in_order_api.model.CuisineType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuisineRepository extends JpaRepository<CuisineType, String> {
}
