package com.satishmankar.attendance.controllers;

import com.satishmankar.attendance.dao.UserDAO;
import com.satishmankar.attendance.dto.*;
import com.satishmankar.attendance.exceptions.PasswordAndConfirmPasswordNotMatchedException;
import com.satishmankar.attendance.exceptions.UserAlreadyExistsException;
import com.satishmankar.attendance.models.User;
import com.satishmankar.attendance.services.IUserService;
import com.satishmankar.attendance.services.UserDetailsService;
import com.satishmankar.attendance.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    UserDAO userDAO;

    @Autowired
    private IUserService userService;


    @PostMapping("/register")
    public ResponseEntity<BasicDTO<RegisterResponseDTO>> registerUser(@RequestBody RegisterRequestDTO registerRequestDTO) {
        RegisterResponseDTO registerResponseDTO = userService.register(registerRequestDTO);
        return new ResponseEntity<>(new BasicDTO<>(registerResponseDTO), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<BasicDTO<LoginResponseDTO>> login(@RequestBody LoginRequestDTO loginRequestDTO){
        LoginResponseDTO result = userService.login(loginRequestDTO);
        return new ResponseEntity<>(new BasicDTO<>(result), HttpStatus.OK );
    }

}
