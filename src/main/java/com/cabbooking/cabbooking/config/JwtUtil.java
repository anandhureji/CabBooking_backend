package com.cabbooking.cabbooking.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {

    SecretKey key = Keys.hmacShaKeyFor(JwtSecurityContext.JWT_KEY.getBytes());
    public String generateJwtToken(Authentication authentication){
        String jwt = Jwts.builder().setIssuer("Anandhu Reji")
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+864000000))
                .claim("email",authentication.getName())
                .signWith(key)
                .compact();
        return jwt;

    }

    public String getEmailFromJwt(String jwt){
        jwt = jwt.substring(7);
        Claims claims =  Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJwt(jwt).getBody();
        String email = String.valueOf(claims.get("email"));
        return email;



    }
}
