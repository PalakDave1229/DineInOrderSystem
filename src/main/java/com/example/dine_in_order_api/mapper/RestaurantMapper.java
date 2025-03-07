package com.example.dine_in_order_api.mapper;

import com.example.dine_in_order_api.dto.request.RestaurantRequest;
import com.example.dine_in_order_api.dto.request.UserRegistrationRequest;
import com.example.dine_in_order_api.dto.request.UserRequest;
import com.example.dine_in_order_api.dto.responce.RestaurestResponse;
import com.example.dine_in_order_api.dto.responce.UserResponce;
import com.example.dine_in_order_api.model.CuisineType;
import com.example.dine_in_order_api.model.Restaurent;
import com.example.dine_in_order_api.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface RestaurantMapper {

      /**
       *
       * used for set restaurantRequest (DTO class to update) data in user object
       *
       * @param restaurantRequest DTO class with updated restaurant details
       * @return restaurent object with RestaurantRequest data
       */
      Restaurent mapToRestaurantEntity(RestaurantRequest restaurantRequest);

      /**
       * getting string value and storing in CuisineType object
       *
       * @param value cuisine type getting in string type
       * @return object of cuisine with string name
       */
      default CuisineType mapToCuisineType(String value) {
            if(value == null) {
                  return null;
            }
            else {
                  CuisineType type = new CuisineType();
                  type.setCuisine(value);
                  return type;
            }
      }

      /**
       * converting cuisine type into String for restaurant response
       *
       * @param value cuisineType object with name
       * @return cuisine name as string
       */
      default String mapToString(CuisineType value) {
            if(value == null) {
                  return null;
            }
            else return value.getCuisine();
      }
      /**
       * create and return structure of restaurentResponse using user object details
       *
       * @param restaurent user entity object
       * @return restaurentResponse object to send restricted attribute
       */
      RestaurestResponse mapToRestaurantResponce(Restaurent restaurent);
}
