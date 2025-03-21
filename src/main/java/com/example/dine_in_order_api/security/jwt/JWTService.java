package com.example.dine_in_order_api.security.jwt;

import com.example.dine_in_order_api.config.AppEnv;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;

@Component
public class JWTService{

    private final AppEnv appEnv;

    public JWTService(AppEnv appEnv) {
        this.appEnv = appEnv;
    }

    public String generateToken(TokenPayload tokenPayload){
        return Jwts.builder()
                .setClaims(tokenPayload.claims())
                .setIssuedAt( Date.from(tokenPayload.issueAt()))
                .setExpiration( Date.from(tokenPayload.expiration()))
                .signWith(KeyHolder.getKey(appEnv.getSecurity().getSecret()), SignatureAlgorithm.HS256)
                .compact();
    }
}
