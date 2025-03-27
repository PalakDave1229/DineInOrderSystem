package com.example.dine_in_order_api.security.fillters;

import com.example.dine_in_order_api.exception.InvaildJWTException;
import com.example.dine_in_order_api.security.jwt.ClaimName;
import com.example.dine_in_order_api.security.jwt.JWTService;
import com.example.dine_in_order_api.security.jwt.TokenBlackListService;
import com.example.dine_in_order_api.security.jwt.TokenType;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.token.Token;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.security.auth.login.CredentialNotFoundException;
import java.io.IOException;
import java.util.List;

@Slf4j
@AllArgsConstructor
public class AuthFillter extends OncePerRequestFilter {

    private final JWTService jwtService;
    private final TokenBlackListService tokenBlackListService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("validating request , finding token  : {}",TokenType.ACCESS.type());
         Cookie[] cookies =request.getCookies();
         String accessToken = FillterHalper.extractToken(TokenType.ACCESS,cookies);
         String refreshToken = FillterHalper.extractToken(TokenType.REFRESH,cookies);
         if(accessToken != null){
             if (!tokenBlackListService.isBlackListed(accessToken)) {
                 log.info("token found : {}", TokenType.ACCESS.type());
                 Claims claims = jwtService.parseToken(accessToken);

                 String email = claims.get(ClaimName.USER_EMAIL, String.class);
                 String role = claims.get(ClaimName.USER_role, String.class);

                 if ((email != null && !email.isBlank()) && (role != null && !role.isBlank())) {

                     if (SecurityContextHolder.getContext().getAuthentication() == null) {
                         UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                                 email,
                                 null,
                                 List.of(new SimpleGrantedAuthority(role)));
                         authToken.setDetails(request);
                         SecurityContextHolder.getContext().setAuthentication(authToken);
                     }
                 }
             }
         }
        else if(refreshToken!= null){

        } else{

             log.warn("Token not found with name : {}",TokenType.ACCESS.type());
         }
         filterChain.doFilter(request,response);
    }
}
