package com.example.dine_in_order_api.repository;

import com.example.dine_in_order_api.model.Image;
import com.example.dine_in_order_api.service.ImageService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image,String> {
}
