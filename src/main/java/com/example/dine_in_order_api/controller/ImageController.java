package com.example.dine_in_order_api.controller;

import com.example.dine_in_order_api.service.ImageService;
import com.example.dine_in_order_api.utility.ResponseBuilder;
import com.example.dine_in_order_api.utility.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("${app.base-url}")
@AllArgsConstructor
public class ImageController {
    private ImageService imageService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/food-items/{foodId}/images")
    public ResponseEntity<ResponseStructure<String>> uploadImage(@PathVariable long foodId ,
                                                                 @RequestParam MultipartFile imageURL) throws IOException {
        String response = imageService.uploadImage(imageURL, foodId);
        return ResponseBuilder
                .created(response,"Image uploaded !!");
    }

}
