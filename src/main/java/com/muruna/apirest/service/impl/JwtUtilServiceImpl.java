package com.muruna.apirest.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.Charset;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.muruna.apirest.service.JwtUtilService;

@Component
public class JwtUtilServiceImpl implements JwtUtilService {
    private static final long serialVersionUID=1L;
    public static final long JWT_TOKEN_VALIDITY=60*60*24*30;

    public final long expirationTimespan;
    private final Key keys;
    
    public JwtUtilServiceImpl(
            @Value("${sbwfjjwt.jjwt.secret}") String secret,
            @Value("${sbwfjjwt.jjwt.expiration}") long expirationTimespan ){
        this.expirationTimespan=expirationTimespan;
        this.keys= Keys.hmacShaKeyFor(secret.getBytes(Charset.forName("UTF-8")));
    }
    

    @Override
    public Date getExpirationDateFromToken(String token){
        return getClaimFromToken(token, Claims::getExpiration);
    }
    
    @Override
    public<T> T getClaimFromToken(String token, Function<Claims,T> claimsResolver){
        Claims claims=getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }
    
    @Override
    public Claims getAllClaimsFromToken(String token){
        return Jwts.parserBuilder().setSigningKey(keys).build().parseClaimsJws(token).getBody();
    }

    @Override
    public Boolean isTokenExpired(String token){
        Date expiration=getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }
    
    @Override
    public String generateToken(String user){
        return generateToken(user,new HashMap<>());
    }
    
    @Override
    public String generateToken(String user, Map<String,Object> claims){
        return doGenerateToken(claims, user);
    }
    
    private String doGenerateToken(Map<String,Object> claims, String subject){
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+expirationTimespan*1_000))
                .signWith(keys)
                .compact();
    }
}