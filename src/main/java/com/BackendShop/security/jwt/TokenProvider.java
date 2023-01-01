package com.BackendShop.security.jwt;

import java.security.Key;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;

import com.BackendShop.user.res.request.SignInReq;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class TokenProvider {

    private final Logger log = LoggerFactory.getLogger(TokenProvider.class);
   
    private static final long EXPIRE_TIME = 86400000000L;
    
    private final JwtParser jwtParser;    
    
    private Key key;
    
    public TokenProvider(SignInReq signInReq) {
		super();
		byte[] keyBytes;
		
        key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		jwtParser = Jwts.parserBuilder().setSigningKey(key).build();

	}
    public String generateTokenLogin(Authentication authentication) {
        SignInReq userPrincipal = (SignInReq) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject((userPrincipal.getEmail()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + EXPIRE_TIME * 1000))
                .signWith(key,SignatureAlgorithm.HS512)
                .compact();
    }
    public String getUserNameFromJwtToken(String token) {

        String userName =jwtParser
                .parseClaimsJws(token)
                .getBody().getSubject();
        return userName;
    }
    public boolean validateToken(String authToken) {
        try {
            jwtParser.parseClaimsJws(authToken);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            log.info("Invalid JWT token.");
            log.trace("Invalid JWT token trace.", e);
        }
        return false;
    }
}
