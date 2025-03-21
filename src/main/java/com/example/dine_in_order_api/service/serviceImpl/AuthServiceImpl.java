package com.example.dine_in_order_api.service.serviceImpl;

import com.example.dine_in_order_api.config.AppEnv;
import com.example.dine_in_order_api.dto.request.AuthRecord;
import com.example.dine_in_order_api.dto.request.LoginRequest;
import com.example.dine_in_order_api.exception.UserNotFoundException;
import com.example.dine_in_order_api.model.User;
import com.example.dine_in_order_api.repository.UserRepository;
import com.example.dine_in_order_api.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final AppEnv appEnv;

    @Override
    public AuthRecord login(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken
                (loginRequest.email(),loginRequest.password());
        Authentication authentication = authenticationManager.authenticate(token);
        if(authentication.isAuthenticated()){
            User user = userRepository.findByEmail(loginRequest.email())
                    .orElseThrow(() -> new UsernameNotFoundException("User not found !!"));
            return generateAuthRecord(user);
        }
        else {
            throw new UsernameNotFoundException("Failed to authenticate !!");
        }
    }

    private AuthRecord generateAuthRecord(User user) {
        Instant now = Instant.now();
        long accessExpiration = now.plusSeconds(appEnv.getSecurity().getTokenValidity().getAccessValidity()).toEpochMilli();
        long refreshExpiration =now.plusSeconds(appEnv.getSecurity().getTokenValidity().getRefreshValidity()).toEpochMilli();

        AuthRecord authRecord = new AuthRecord(
                        user.getUserid(),
                        user.getUsername(),
                        user.getEmail(),
                        user.getUserrole(),
                        accessExpiration,
                        refreshExpiration
                );
        return authRecord;
    }
}
