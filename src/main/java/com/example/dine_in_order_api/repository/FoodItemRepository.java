package com.example.dine_in_order_api.repository;

import com.example.dine_in_order_api.model.Category;
import com.example.dine_in_order_api.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FoodItemRepository extends JpaRepository<FoodItem,Long> {


    @Query("SELECT fi FROM FoodItem fi INNER JOIN fi.categories c " +
            "WHERE c.category IN :categories " +
            "GROUP BY fi.id " +
            "HAVING COUNT(DISTINCT c.category) = :categoryCount")
    List<FoodItem> findByTwoCategories(
            @Param("categories") List<String> categories,
            @Param("categoryCount") int categoryCount);
}
