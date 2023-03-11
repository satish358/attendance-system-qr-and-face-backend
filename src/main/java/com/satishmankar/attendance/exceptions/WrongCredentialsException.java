package com.satishmankar.attendance.exceptions;

public class WrongCredentialsException extends RuntimeException{
    public WrongCredentialsException() {
        super("Entered email or password not matched.");
    }
}
