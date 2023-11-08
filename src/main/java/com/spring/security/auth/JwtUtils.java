package com.spring.security.auth;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {

    private final String secret_key = "mySecretKey";
    private long accessTokenValidity = 60*60*1000;
    private final JwtParser jwtParser;
    private final String TOKEN_HEADER = "Authorization";
    private final String TOKEN_PREFIX = "Bearer";

    //constructor

    public JwtUtils(JwtParser jwtParser){
        this.jwtParser = Jwts.parser().setSigningKey(secret_key);
    }
}
