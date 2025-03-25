package com.example.dine_in_order_api.service.helper;

import com.example.dine_in_order_api.config.AppEnv;
import com.example.dine_in_order_api.security.jwt.JWTService;
import com.example.dine_in_order_api.security.jwt.TokenPayload;
import com.example.dine_in_order_api.security.jwt.TokenType;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;

@Component
@AllArgsConstructor
public class TokenGenerationServiceHelper{

    private final JWTService jwtService;
    private final AppEnv appEnv;

    public String generateToken(TokenType tokenType,Map<String,Object> claims, Instant shouldExpireAt){

        TokenPayload payload = generateTokenPayload(tokenType,claims,shouldExpireAt);

        String token = jwtService.generateToken(payload);

        long maxAge = Duration.between(Instant.now(),shouldExpireAt).getSeconds();

        return generateCookie(tokenType,token,maxAge);
    }

    private String generateCookie(TokenType tokenType, String token,long maxAge){

         return ResponseCookie.from(tokenType.type(),token)
                 .domain(appEnv.getDomain().getName())
                 .path("/")
                 .sameSite(appEnv.getDomain().getSameSite())
                 .httpOnly(true)
                 .secure(appEnv.getDomain().isSecure())
                 .maxAge(maxAge)
                 .build().toString();

    }

    public TokenPayload generateTokenPayload(TokenType tokenType, Map<String, Object> claims, Instant shouldExpireAt){

        Instant issueAt = calculateIssueTime(tokenType, shouldExpireAt);

        return new TokenPayload(claims,issueAt,shouldExpireAt);

    }

    private Instant calculateIssueTime(TokenType tokenType, Instant shouldExpireAt) {
        Instant issueAt;

        switch (tokenType){
            case ACCESS -> {
                issueAt = shouldExpireAt.minusSeconds(appEnv.getSecurity().getTokenValidity().getAccessValidity());
            }
            case REFRESH -> {
                issueAt = shouldExpireAt.minusSeconds(appEnv.getSecurity().getTokenValidity().getRefreshValidity());
            }
            default -> throw new IllegalArgumentException("Illegal Token Type Specified !!");
        }
        return issueAt;
    }
}
