package com.example.dine_in_order_api.repository;

import com.example.dine_in_order_api.model.Restaurent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RestaurentRepository extends JpaRepository<Restaurent,Long> {

    Restaurent findNameByFoodItems_Id(long foodId);

}
