package com.example.dine_in_order_api.service.service;

import com.example.dine_in_order_api.dto.request.RegistrationRequest;
import com.example.dine_in_order_api.dto.responce.UserResponce;
import com.example.dine_in_order_api.enums.UserRole;
import com.example.dine_in_order_api.exception.UserNotFoundException;
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
    public UserResponce registration(RegistrationRequest registrationRequest) {
        User user = this.getUser(registrationRequest.getUserrole());
        System.out.println(user.getUserrole());
        this.mapToUserEntity(registrationRequest, user);
        return mapToUserResponce(userRepository.save(user));
    }

    private UserResponce mapToUserResponce(User source) {
        return  UserResponce.builder()
                .username(source.getUsername())
                .userid(source.getUserid())
                .userrole(source.getUserrole())
                .build();
    }

    private void mapToUserEntity( RegistrationRequest source,User target) {
        target.setEmail(source.getEmail());
        target.setPhno(source.getPhno());
        target.setUsername(source.getUsername());
        target.setPassword(source.getPassword());
        target.setUserrole(source.getUserrole());
    }

    @Override
    public UserResponce findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User Not Found ,Invaild User Id"));
        return mapToUserResponce(user);
    }

    @Override
    public UserResponce updateById(User user, Long userId) {
         User userRes =userRepository.findById(userId)
                 .orElseThrow(() -> new UserNotFoundException("User Not found to update"));
         mapToUser(user,userRes);
          return mapToUserResponce(userRepository.save(userRes));
    }

    private  User getUser(UserRole role) {
        User user2;
        switch(role){
            case ADMIN ->user2 = new Admin();
            case STAFF ->user2 = new Staff();
            default -> throw new RuntimeException("Failed to register user, Invaild user type");
        }
        return user2;
    }

    private  void mapToUser(User source, User target) {
        target.setEmail(source.getEmail());
        target.setPhno(source.getPhno());
        target.setPassword(source.getPassword());
        target.setUsername(source.getUsername());
        target.setUserrole(source.getUserrole());
    }
}
