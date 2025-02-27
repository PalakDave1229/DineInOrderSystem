package com.gitDemo.demo.controller;

import com.gitDemo.demo.model.User;
import com.gitDemo.demo.service.UserService;
import com.gitDemo.demo.utility.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<ResponseStructure<User>> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}
