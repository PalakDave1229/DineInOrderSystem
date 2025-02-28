package com.example.dine_in_order_api.service.service;

import com.example.dine_in_order_api.dto.request.RegistrationRequest;
import com.example.dine_in_order_api.dto.request.UserRequest;
import com.example.dine_in_order_api.dto.responce.UserResponce;
import com.example.dine_in_order_api.enums.UserRole;
import com.example.dine_in_order_api.exception.UserNotFoundException;
import com.example.dine_in_order_api.mapper.UserMapper;
import com.example.dine_in_order_api.model.Admin;
import com.example.dine_in_order_api.model.Staff;
import com.example.dine_in_order_api.model.User;
import com.example.dine_in_order_api.repository.UserRepository;
import com.example.dine_in_order_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponce registration(RegistrationRequest registrationRequest) {
        User user = this.getUser(registrationRequest.getUserrole());
        System.out.println(user.getUserrole());
        UserMapper.mapToUserEntity(registrationRequest, user);
        return UserMapper.mapToUserResponce(userRepository.save(user));
    }

    @Override
    public UserResponce findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User Not Found ,Invaild User Id"));
        return UserMapper.mapToUserResponce(user);
    }

    @Override
    public UserResponce updateById(UserRequest userRes, Long userId) {
         User user =userRepository.findById(userId)
                   .orElseThrow(() -> new UserNotFoundException("User Not found to update"));
         UserMapper.mapToUser(userRes,user);
         return UserMapper.mapToUserResponce(userRepository.save(user));
    }

    private User getUser(UserRole role) {
        User user2;
        switch(role){
            case ADMIN ->user2 = new Admin();
            case STAFF ->user2 = new Staff();
            default -> throw new RuntimeException("Failed to register user, Invaild user type");
        }
        return user2;
    }
}
