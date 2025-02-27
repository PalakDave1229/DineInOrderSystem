package com.example.dine_in_order_api.service.service;

import com.example.dine_in_order_api.enums.UserRole;
import com.example.dine_in_order_api.model.Admin;
import com.example.dine_in_order_api.model.Staff;
import com.example.dine_in_order_api.model.User;
import com.example.dine_in_order_api.repository.UserRepository;
import com.example.dine_in_order_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User registration(User user) {

        User user2 = this.getUser(user.getUserrole());
        this.mapToUser(user, user2);
        return userRepository.save(user2);
    }

//    @Override
//    public User findById(Long id) {
//
//        Optional<User> user = userRepository.findById(id);
//        return user.get();
//    }

    private  User getUser(UserRole role) {
        User user2;
        switch(role){
            case ADMIN ->user2 = new Admin();
            case STAFF ->user2 = new Staff();
            default -> throw new RuntimeException("Failed to register user, Invaild user type");
        }
        return user2;
    }

    private  void mapToUser(User user, User user2) {
        user2.setEmail(user.getEmail());
        user2.setPhno(user.getPhno());
        user2.setPassword(user.getPassword());
        user2.setUsername(user.getUsername());
        user2.setUserrole(user.getUserrole());
    }
}
