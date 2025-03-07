package com.example.dine_in_order_api.mapper;


import com.example.dine_in_order_api.dto.request.UserRegistrationRequest;
import com.example.dine_in_order_api.dto.request.UserRequest;
import com.example.dine_in_order_api.dto.responce.UserResponce;
import com.example.dine_in_order_api.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {

      /**
       *
       * used for set userRequest (DTO class to update) data in user object
       *
       * @param userRequest DTO class with updated user details
       * @param user object of user entity
       */
      void mapToUser(UserRequest userRequest,@MappingTarget User user);

      /**
       *
       * used for set RegistrationRequest (DTO class to register) data in user object
       *
       * @param updatedUser DTO class object with user detail
       * @param user object of user entity
       */
      void mapToUserEntity(UserRegistrationRequest updatedUser, @MappingTarget User user);

      /**
       *
       * create and return structure of UserResponse using user object details
       *
       * @param user user entity object
       * @return userResponse object to send restricted attribute
       */
      UserResponce mapToUserResponce(User user);
}
