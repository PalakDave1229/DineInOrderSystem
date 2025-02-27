package com.example.dine_in_order_api.controller;

import com.example.dine_in_order_api.model.User;
import com.example.dine_in_order_api.service.UserService;
import com.example.dine_in_order_api.utility.ResponseBuilder;
import com.example.dine_in_order_api.utility.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<ResponseStructure<User>> registration(@RequestBody User user) {
        user = userService.registration(user);
        return ResponseBuilder.success(user,HttpStatus.CREATED,"Data Stored !!");
    }

    //find by id
//    @GetMapping
//    public ResponseEntity<ResponseStructure<User>> findById(int id) {
//        User user ;
//        return ResponseBuilder.success(user,HttpStatus.CREATED,"Data Stored !!");
//    }


    //update by id



}
