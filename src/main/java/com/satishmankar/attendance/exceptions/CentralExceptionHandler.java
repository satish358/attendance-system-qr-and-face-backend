package com.satishmankar.attendance.exceptions;

import com.satishmankar.attendance.dto.BasicDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralExceptionHandler {
    @ExceptionHandler(PasswordAndConfirmPasswordNotMatchedException.class)
    public ResponseEntity<BasicDTO<String>> handlePasswordAndConfirmPasswordNotMatchedException(PasswordAndConfirmPasswordNotMatchedException e){
        return new ResponseEntity<>(new BasicDTO<>(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<BasicDTO<String>> handleUserAlreadyExistsException(UserAlreadyExistsException e){
        return new ResponseEntity<>(new BasicDTO<>(e.getMessage()), HttpStatus.CONFLICT);
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<BasicDTO<String>> handleUserNotFoundException(UserNotFoundException e){
        return new ResponseEntity<>(new BasicDTO<>(e.getMessage()), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UserNotActiveException.class)
    public ResponseEntity<BasicDTO<String>> handleUserNotActiveException(UserNotActiveException e){
        return new ResponseEntity<>(new BasicDTO<>(e.getMessage()), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(WrongCredentialsException.class)
    public ResponseEntity<BasicDTO<String>> handleWrongCredentialsException(WrongCredentialsException e){
        return new ResponseEntity<>(new BasicDTO<>(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

//@ExceptionHandler(PasswordAndConfirmPasswordNotMatchedException.class)
//    public ResponseEntity<BasicDTO<String>> handle(PasswordAndConfirmPasswordNotMatchedException e){
//        return new ResponseEntity<>(new BasicDTO<>(e.getMessage()), HttpStatus.BAD_REQUEST);
//    }
}
