package com.system.subscriptionmembershipmanagement.services;

import com.system.subscriptionmembershipmanagement.config.JwtConfig;
import com.system.subscriptionmembershipmanagement.enums.UserRole;
import com.system.subscriptionmembershipmanagement.security.CustomUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class JwtService {
    private final JwtConfig jwtConfig;

    public String generateToken(CustomUserDetails user) {

        return Jwts
                .builder()
                .subject(user.getId().toString())
                .claim("role",user.getRole())
                .claim("email",user.getEmail())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000L * jwtConfig.getToken_expiration() ))
                .signWith(jwtConfig.getSecretKey())
                .compact();
    }

    public Claims claims(String token){
        return Jwts
                .parser()
                .verifyWith(jwtConfig.getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean validateToken(String token){
        try {
            var claims = claims(token);
            return claims.getExpiration().after(new Date());
        } catch (JwtException e) {
            return false;
        }
    }

    public Long getUserIdFromToken(String token){
        return Long.valueOf(claims(token).getSubject());
    }
    public String getEmailFromToken(String token){
        return claims(token).get("email",String.class);
    }
    public UserRole getRoleFromToken(String token){
        return UserRole.valueOf(claims(token).get("role",String.class));
    }
}
