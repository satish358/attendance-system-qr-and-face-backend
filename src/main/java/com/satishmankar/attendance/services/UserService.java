package com.satishmankar.attendance.services;

import com.satishmankar.attendance.dao.UserDAO;
import com.satishmankar.attendance.dto.*;
import com.satishmankar.attendance.exceptions.*;
import com.satishmankar.attendance.models.User;
import com.satishmankar.attendance.utils.JWTUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService implements IUserService{
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JWTUtil jwtUtil;
    @Override
    public RegisterResponseDTO register(RegisterRequestDTO r) {
        if( !r.getPassword().equals(r.getConfirmPassword()) ){
            throw new PasswordAndConfirmPasswordNotMatchedException();
        }
        if(userDAO.existsByEmail(r.getEmail())
                || userDAO.existsByAadharNumber(r.getAadharNumber())){
            throw new UserAlreadyExistsException();
        }
        User user = modelMapper.map(r, User.class);
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(r.getPassword()));
        user.setCreatedOn(LocalDateTime.now());
        user.setUniqueCode(passwordEncoder.encode("UID_"+LocalDateTime.now() + r.getAadharNumber() +r.getEmail()));
        userDAO.save(user);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
        return new RegisterResponseDTO(jwtUtil.generateToken(userDetails), user.getEmail(), user.getFirstName());

    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO r) {
        return login(r.getEmail(), r.getPassword());
    }

    @Override
    public LoginResponseDTO login(String email, String password) {
        User user = userDAO.findUserByEmail(email).orElseThrow(UserNotFoundException::new);
        if(!user.getActive()) throw new UserNotActiveException();
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            email,
                            password
                    )
            );
        } catch (BadCredentialsException e) {
            throw new WrongCredentialsException();
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        loginResponseDTO.setToken(jwtUtil.generateToken(userDetails));
        loginResponseDTO.setUser(user);
        return loginResponseDTO;
    }
}
