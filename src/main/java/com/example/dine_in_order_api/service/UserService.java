package com.gitDemo.demo.service;

import com.gitDemo.demo.model.User;
import com.gitDemo.demo.utility.ResponseStructure;
import org.springframework.http.ResponseEntity;

public interface UserService {
    public ResponseEntity<ResponseStructure<User>> addUser(User user);
}
