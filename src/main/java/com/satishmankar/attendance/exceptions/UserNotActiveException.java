package com.satishmankar.attendance.exceptions;

public class UserNotActiveException extends RuntimeException{
    public UserNotActiveException() {
        super("User not active. please contact admin.");
    }
}
