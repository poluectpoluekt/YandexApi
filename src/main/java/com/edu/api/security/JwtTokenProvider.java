package com.edu.api.security;

import com.edu.api.entity.User;
import com.edu.api.exception.jwt.TokenExpiredException;

import com.edu.api.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


/**
 * Класс для генерации и валидации JWT
 */
@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    private static final Logger LOG = LoggerFactory.getLogger(JwtTokenProvider.class);
    private final UserRepository userRepository;

    @Value("${app.security.secret}")
    private String jwtSigningKey;

    public String generateToken(String username){

        User user = userRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException(username));
        Date now = new Date(System.currentTimeMillis());
        Date expirationDateToken = Date.from(ZonedDateTime.now().plusMinutes(60).toInstant()); //время действия токена 60 минут с времени создания
        Map<String, Object> claimsMap = new HashMap<>();
        claimsMap.put("username", username);
        claimsMap.put("roles", user.getRoles());

        return Jwts.builder().claims(claimsMap).subject(username).issuedAt(now)
                .expiration(expirationDateToken).signWith(getSigningKey()).compact();
    }


    private SecretKey getSigningKey() {

        /**
         * позже можно переделать получение подпись для jwt, создать ключ один раз, а не делать каждый раз.
         */
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSigningKey));
    }

    public boolean validateToken(String token){
        Optional<User> user = userRepository.findByEmail(extractUsername(token));
        Claims claims = Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token).getPayload();

        if(claims.getExpiration().after(new Date()) && user.isPresent()){
            return true;
        }
        throw new TokenExpiredException();

    }

    public String extractUsername(String token){

        return Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token).getPayload().getSubject();

    }
}
