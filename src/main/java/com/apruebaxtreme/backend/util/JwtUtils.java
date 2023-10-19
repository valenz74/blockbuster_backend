package com.apruebaxtreme.backend.util;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

/**
 * JwtUtils
 */
public class JwtUtils {

    private static String secret = "apruebaxtreme";
    private static Long duracion = 1440*60000L;
    private static Algorithm algorithm = Algorithm.HMAC256(secret);
    
    public static String crearJwtToken(String username, String role){
        String jwtToken = JWT.create()
        .withClaim("username",username)
        .withClaim("role",role)
        .withExpiresAt(new Date(System.currentTimeMillis()+duracion))
        .sign(algorithm);

        return jwtToken;
    }

    public static boolean tokenValido(String jwtToken){

        JWTVerifier verifier = JWT.require(algorithm).build();
        
        try {
            verifier.verify(jwtToken);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }

    }

    public static String username(String jwtToken){

        JWTVerifier verifier = JWT.require(algorithm).build();
        return verifier.verify(jwtToken).getClaim("username").asString();

    }
}