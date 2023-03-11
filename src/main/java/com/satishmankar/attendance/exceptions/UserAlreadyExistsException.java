package com.satishmankar.attendance.exceptions;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException() {
        super("User already present in database");
    }
}
