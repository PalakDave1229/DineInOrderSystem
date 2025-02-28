package com.example.dine_in_order_api.mapper;

import com.example.dine_in_order_api.dto.request.RegistrationRequest;
import com.example.dine_in_order_api.dto.request.UserRequest;
import com.example.dine_in_order_api.dto.responce.UserResponce;
import com.example.dine_in_order_api.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public static void mapToUser(UserRequest sourse, User target){
        target.setEmail(sourse.getEmail());
        target.setPhno(sourse.getPhno());
        target.setUsername(sourse.getUsername());
    }
    public static void mapToUserEntity(RegistrationRequest source, User target) {
        target.setEmail(source.getEmail());
        target.setPhno(source.getPhno());
        target.setUsername(source.getUsername());
        target.setPassword(source.getPassword());
        target.setUserrole(source.getUserrole());
    }
    public static UserResponce mapToUserResponce(User source) {
        return  UserResponce.builder()
                .username(source.getUsername())
                .userid(source.getUserid())
                .userrole(source.getUserrole())
                .build();
    }
    public static void mapToUser(User source, User target) {
        target.setEmail(source.getEmail());
        target.setPhno(source.getPhno());
        target.setPassword(source.getPassword());
        target.setUsername(source.getUsername());
        target.setUserrole(source.getUserrole());
    }
}
