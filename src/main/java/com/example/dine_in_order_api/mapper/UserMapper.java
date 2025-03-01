package com.example.dine_in_order_api.mapper;

import com.example.dine_in_order_api.dto.request.RegistrationRequest;
import com.example.dine_in_order_api.dto.request.UserRequest;
import com.example.dine_in_order_api.dto.responce.UserResponce;
import com.example.dine_in_order_api.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {
      void mapToUser(UserRequest userRequest,@MappingTarget User user);
      void mapToUserEntity(RegistrationRequest updatedUser,@MappingTarget User user);
      UserResponce mapToUserResponce(User user);
}
