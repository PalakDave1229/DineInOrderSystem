package com.gitDemo.demo.serviceimp;

import com.gitDemo.demo.model.User;
import com.gitDemo.demo.repository.UserRepository;
import com.gitDemo.demo.service.UserService;
import com.gitDemo.demo.utility.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<ResponseStructure<User>> addUser(User user) {
        User Response = userRepository.save(user);
        ResponseStructure<User> rs = new ResponseStructure<>();
        rs.setHttpStatus(HttpStatus.CREATED.value());
        rs.setMessage("User Data Stored !!");
        rs.setObject(Response);
        return new ResponseEntity<>(rs, HttpStatus.CREATED);
    }
}
