package com.edu.api.exception;

public class UserAlreadyExistsException extends RuntimeException{

    public UserAlreadyExistsException(String email){
        super("A user with this email already exists" + email);
    }
}
