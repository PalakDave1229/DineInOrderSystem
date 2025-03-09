package com.example.dine_in_order_api.service.serviceImpl;

import com.example.dine_in_order_api.dto.request.RestaurantRequest;
import com.example.dine_in_order_api.dto.responce.RestaurestResponse;
import com.example.dine_in_order_api.exception.UserNotFoundException;
import com.example.dine_in_order_api.mapper.RestaurantMapper;
import com.example.dine_in_order_api.model.Admin;
import com.example.dine_in_order_api.model.CuisineType;
import com.example.dine_in_order_api.model.Restaurent;
import com.example.dine_in_order_api.model.User;
import com.example.dine_in_order_api.repository.CuisineRepository;
import com.example.dine_in_order_api.repository.RestaurentRepository;
import com.example.dine_in_order_api.repository.UserRepository;
import com.example.dine_in_order_api.service.RestaurentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.List;

@Service
@AllArgsConstructor
public class RestaurantServiceImpl implements RestaurentService {

    private UserRepository userRepository;
    private RestaurentRepository restaurentReposetory;
    private final CuisineRepository cuisineRepository;
    private RestaurantMapper restaurantMapper;


    @Override
    public RestaurestResponse createRestaurant(long userId, RestaurantRequest restaurantRequest) {
         User user =userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User Not Found , Invaild User Id"));
         if(user instanceof Admin admin){
             Restaurent restaurent = restaurantMapper.mapToRestaurantEntity(restaurantRequest);

             List<CuisineType> cuisineTypes = this.createNonExistingCuisineTypes(restaurent.getCuisineTypes());
             restaurent.setCuisineTypes(cuisineTypes);
             restaurent.setAdmin(admin);

             restaurentReposetory.save(restaurent);

             return restaurantMapper.mapToRestaurantResponce(restaurent);
         }
         else {
             try {
                 throw new AccessDeniedException("unauthorized operation !!");
             } catch (AccessDeniedException e) {
                 throw new RuntimeException(e);
             }
         }
    }

    private List<CuisineType> createNonExistingCuisineTypes(List<CuisineType> cuisineTypes) {
        return cuisineTypes.stream()
                .map(type -> cuisineRepository.findById(type.getCuisine())
                        .orElseGet(() -> {
                            type.setCuisine(type.getCuisine().toLowerCase());
                            return cuisineRepository.save(type);
                        }
                        ))
                .toList();
    }
}
