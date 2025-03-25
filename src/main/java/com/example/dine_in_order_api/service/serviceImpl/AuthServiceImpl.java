package com.example.dine_in_order_api.service.serviceImpl;

import com.example.dine_in_order_api.config.AppEnv;
import com.example.dine_in_order_api.dto.request.AuthRecord;
import com.example.dine_in_order_api.dto.request.LoginRequest;
import com.example.dine_in_order_api.exception.UserNotFoundException;
import com.example.dine_in_order_api.model.User;
import com.example.dine_in_order_api.repository.UserRepository;
import com.example.dine_in_order_api.security.jwt.ClaimName;
import com.example.dine_in_order_api.security.jwt.JWTService;
import com.example.dine_in_order_api.security.jwt.TokenPayload;
import com.example.dine_in_order_api.security.jwt.TokenType;
import com.example.dine_in_order_api.service.AuthService;
import com.example.dine_in_order_api.service.TokenGenerationService;
import com.example.dine_in_order_api.service.helper.TokenGenerationServiceHelper;
import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final AppEnv appEnv;
    private final JWTService jwtService;
    private final TokenGenerationServiceHelper tokenGenerationServiceHelper;
    private final TokenGenerationService tokenGenerationService;

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

    @Override
    public AuthRecord refreshLogin(String refreshToken){
        Claims claims = jwtService.parseToken(refreshToken);

        String email = claims.get(ClaimName.USER_EMAIL, String.class);
        long refereshExpiration = claims.getExpiration().toInstant().toEpochMilli();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found !!"));;

        long accessExpiration = Instant.now().plusSeconds(3600).toEpochMilli();

        AuthRecord authRecord = new AuthRecord(
                user.getUserid(),
                user.getUsername(),
                email,
                user.getUserrole(),
                accessExpiration,
                refereshExpiration
        );

        return authRecord;
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
