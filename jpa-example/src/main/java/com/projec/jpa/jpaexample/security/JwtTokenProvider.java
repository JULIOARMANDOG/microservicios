package com.projec.jpa.jpaexample.security;

import com.projec.jpa.jpaexample.exception.BlogAPIException;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class JwtTokenProvider {

    @Value("${jwt_secret}")
    private String jwt_secret;

    @Value("${jwt-expiration-milliseconds}")
    private  int expirationMilliseconds;

    //generamos el token
    public String generateToken(Authentication authentication){
        String username=authentication.getName();
        Date currentDate= new Date();
        Date expired= new Date(currentDate.getTime()+ expirationMilliseconds);
        String token= Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expired)
                .signWith(SignatureAlgorithm.HS512,jwt_secret)
                .compact();

      return token;
    }


    //get username form token
    public String getUserNameFromJwt(String token){
        Claims claim=Jwts.parser()
                .setSigningKey(jwt_secret)
                .parseClaimsJws(token)
                .getBody();
        return claim.getSubject();

    }

    //validate jwt token
    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(jwt_secret).parseClaimsJws(token);
            return  true;

        }catch (SignatureException ex){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST,"Invalid Jwt signature");
        }catch (MalformedJwtException ex){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST,"Invalid Jwt token");
        }catch (ExpiredJwtException ex){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST,"Expired Jwt token");
        }catch (UnsupportedJwtException ex){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST,"Unsupported Jwt token");
        }catch (IllegalArgumentException ex){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST,"Jwt claims streing is empty");
        }


    }
}
