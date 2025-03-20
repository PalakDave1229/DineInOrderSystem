package com.example.dine_in_order_api.service.serviceImpl;

import com.example.dine_in_order_api.dto.request.UserRegistrationRequest;
import com.example.dine_in_order_api.dto.request.UserRequest;
import com.example.dine_in_order_api.dto.responce.UserResponce;
import com.example.dine_in_order_api.enums.UserRole;
import com.example.dine_in_order_api.mapper.UserMapper;
import com.example.dine_in_order_api.model.Admin;
import com.example.dine_in_order_api.model.RestaurantTable;
import com.example.dine_in_order_api.model.Staff;
import com.example.dine_in_order_api.model.User;
import com.example.dine_in_order_api.repository.TableRepository;
import com.example.dine_in_order_api.repository.UserRepository;
import com.example.dine_in_order_api.security.util.UserIentity;
import com.example.dine_in_order_api.service.UserService;
import lombok.AllArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final TableRepository tableRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserIentity userIentity;

    @Override
    public UserResponce registration(UserRegistrationRequest registrationRequest) {
        User user = this.getUser(registrationRequest.getUserrole());
        if(user instanceof Staff){
            List<RestaurantTable> tableList = tableRepository.findAll();
        }
        userMapper.mapToUserEntity(registrationRequest, user);
        encryptPassword(user);
        return userMapper.mapToUserResponce(userRepository.save(user));
    }
    private void encryptPassword(User user){
       String encodedPassword =  passwordEncoder.encode(user.getPassword());
       user.setPassword(encodedPassword);
    }
    @Override
    public UserResponce findById() {
        User user = userIentity.getCurrentUser();
        userRepository.findById(Long.valueOf(user.getUserid()));
        return userMapper.mapToUserResponce(user);
    }

    @Override
    public UserResponce updateById(UserRequest userRes) {
         User user = userIentity.getCurrentUser();
         userMapper.mapToUser(userRes,user);
         return userMapper.mapToUserResponce(userRepository.save(user));
    }

    /**
     *
     * produce and return child instance of the user based on the user role
     *
     * @param role role of the user
     * @return User the parent reference containing either of STAFF or ADMIN instance
     */

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
