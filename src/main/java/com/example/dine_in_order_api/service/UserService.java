package com.example.dine_in_order_api.service;

import com.example.dine_in_order_api.dto.request.RegistrationRequest;
import com.example.dine_in_order_api.dto.request.UserRequest;
import com.example.dine_in_order_api.dto.responce.UserResponce;

public interface UserService {

    /**
     *
     * registration method helps to accept  registrationRequest as user detail and check that data is ADMIN or STAFF
     * then map that data in user object and save using jpa repository
     *
     * @param registrationRequest it contains data of user to register with restriction using DTO class
     * @return the data which stored in entity with the restriction of userResponce class
     */
    public UserResponce registration(RegistrationRequest registrationRequest);


    /**
     *
     * findById method helps to get the data of user by userId
     *
     * @param id id of user to find detail
     * @return user details of th particular id
     */
    public UserResponce findById(Long id);

    /**
     * updateById use to update details of user of specific user id
     *
     * @param user updated data of user
     * @param userId id of user which user want to update
     * @return updated data of user
     */
    public UserResponce updateById(UserRequest user, Long userId);
}