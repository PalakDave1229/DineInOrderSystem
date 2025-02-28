package com.example.dine_in_order_api.controller;

import com.example.dine_in_order_api.dto.request.RegistrationRequest;
import com.example.dine_in_order_api.dto.request.UserRequest;
import com.example.dine_in_order_api.dto.responce.UserResponce;
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
    public ResponseEntity<ResponseStructure<UserResponce>> registration(@RequestBody RegistrationRequest registrationRequest) {
        System.out.println(registrationRequest.getEmail());
        System.out.println(registrationRequest.getUserrole());
        UserResponce registratin = userService.registration(registrationRequest);
        return ResponseBuilder.success(registratin,HttpStatus.CREATED,"Data Stored !!");
    }

    //find by id
    @GetMapping("/fetch")
    public ResponseEntity<ResponseStructure<UserResponce>> findById(@RequestParam Long id) {
        UserResponce user = userService.findById(id);
        return ResponseBuilder.success(user,HttpStatus.FOUND,"Data Fetched !!");
    }


    //update by id
    @PutMapping("/update")
    public ResponseEntity<ResponseStructure<UserResponce>> updateById(@RequestBody UserRequest user, @RequestParam Long userId){
        UserResponce userRes = userService.updateById(user,userId);
        return ResponseBuilder.success(userRes,HttpStatus.OK,"Data Updated");
    }
}
