package com.example.dine_in_order_api.repository;

import com.example.dine_in_order_api.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,String> {

}
