package com.example.dine_in_order_api.repository;

import com.example.dine_in_order_api.model.Restaurent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurentRepository extends JpaRepository<Restaurent,Long> {

}
