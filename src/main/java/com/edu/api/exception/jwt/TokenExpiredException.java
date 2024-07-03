package com.edu.api.exception.jwt;

public class TokenExpiredException extends RuntimeException{

    public TokenExpiredException(){
        super("token has expired");
    }
}
