package com.example.dine_in_order_api.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;

@Component
public class JWTService{

    private final String secerate = "a2HBwvVicxj/H3ttNMrKptd2FpjP7j8I2fy3c1I9NJw="; //openssl rand -base64 32
    private final Key key;
    {
        this.key = generateKey();
    }
    public String generateToken(TokenPayload tokenPayload){
        return Jwts.builder()
                .setClaims(tokenPayload.claims())
                .setIssuedAt(new Date(tokenPayload.issueAt()))
                .setExpiration(new Date(tokenPayload.expiration()))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
    public Key generateKey(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secerate));
    }
}
