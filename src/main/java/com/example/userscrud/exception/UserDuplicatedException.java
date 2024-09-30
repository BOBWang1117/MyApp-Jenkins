package com.example.userscrud.exception;

public class UserDuplicatedException extends RuntimeException {

    public UserDuplicatedException(String message) {
        super(message);
    }
}
