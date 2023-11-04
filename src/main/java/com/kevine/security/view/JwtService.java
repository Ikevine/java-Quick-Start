package com.kevine.security.view;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY = "VBmxEIlYIkt0J56gny745WdldjmThDOP";

    public String extractUserName(String token) {
        return extractClaim(token , Claims::getSubject);
    }

    public <T> T extractClaim(String token , Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public boolean isTokenValid(String token , UserDetails userDetails){
        final String username = extractUserName(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpire(token);
    }
    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>() , userDetails);
    }

    private boolean isTokenExpire(String token){
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token , Claims::getExpiration);
    }


    public String generateToken(
            Map<String , Object> extraClaims,
            UserDetails userDetails
    ){
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()))
                .signWith(getSignInKey(), SignatureAlgorithm.ES256)
                .compact();
    }
    private Claims extractAllClaims(String token){
        //we are going to extract all the claims
        return Jwts
                .parserBuilder()
                //is used to create signature
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] byteKey = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(byteKey);
    }
}
