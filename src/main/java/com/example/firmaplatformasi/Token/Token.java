package com.example.firmaplatformasi.Token;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Token {
    long time = 3600000;
    Date deadline = new Date(System.currentTimeMillis() + time);
    String password = "Shunchaki kalit";

    public String tokenOlish(String username) {
        String token = Jwts
                .builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(deadline)
                .signWith(SignatureAlgorithm.HS512, password)
                .compact();
        return token;
    }

    public boolean tokenTekshirish(String token) {
        Jwts
                .parser()
                .setSigningKey(password)
                .parseClaimsJws(token);
        return true;
    }

    public String usernameTekshirish(String username) {
        String s = Jwts
                .parser()
                .setSigningKey(password)
                .parseClaimsJws(username)
                .getBody()
                .getSubject();
        return s;

    }
}
