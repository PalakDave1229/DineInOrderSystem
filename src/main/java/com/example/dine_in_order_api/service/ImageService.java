package com.example.dine_in_order_api.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    String uploadImage(MultipartFile file,long foodId) throws IOException;
}
