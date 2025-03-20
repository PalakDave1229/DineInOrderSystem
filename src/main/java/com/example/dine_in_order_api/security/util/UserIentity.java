package com.example.dine_in_order_api.security.util;

import com.example.dine_in_order_api.exception.InligalActivityException;
import com.example.dine_in_order_api.exception.UserNotFoundException;
import com.example.dine_in_order_api.model.User;
import com.example.dine_in_order_api.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserIentity {

    private final UserRepository userRepository;

    public Authentication getAuthentication(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public String getCurrentUserEmail(){
        return getAuthentication().getName();
    }

    public User getCurrentUser(){
        return userRepository.findByEmail(getCurrentUserEmail())
                            .orElseThrow(() -> new UserNotFoundException("User not found !!"));
    }
    public void validateOwnership(String ownerName){
        if(!getCurrentUserEmail().equals(ownerName))
            throw new InligalActivityException("user is not allowed to modify resource request");
    }
}
