package com.muruna.apirest.service;

import io.jsonwebtoken.Claims;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

public interface JwtUtilService {


    public Date getExpirationDateFromToken(String token);

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver);

    public Claims getAllClaimsFromToken(String token);

    public Boolean isTokenExpired(String token);

    public String generateToken(String user);

    public String generateToken(String user, Map<String, Object> claims);

}
