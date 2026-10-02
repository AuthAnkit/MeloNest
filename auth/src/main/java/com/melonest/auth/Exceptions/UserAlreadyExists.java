package com.melonest.auth.Exceptions;

public class UserAlreadyExists extends RuntimeException {
    public UserAlreadyExists(String message) {
        super("User already exists: " + message);
    }
}
