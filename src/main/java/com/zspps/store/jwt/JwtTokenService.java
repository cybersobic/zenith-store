package com.zspps.store.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.util.Date;

@Service
public class JwtTokenService {
    private static final String SECRET_KEY = "2e998caa664c6dd315c7e4c7f3d495b8f737cf9f1db33ecc52d4760f22595395";
    private static final long EXPIRATION_TIME = 3600000;

    private static final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    public String generateToken(String login) {
        return Jwts.builder()
                .setSubject(login)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public static String validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return claims.getBody().getSubject();
        }
        catch (JwtException | IllegalArgumentException e) {
            throw new RuntimeException("JWT токен недействителен!");
        }
    }
}
