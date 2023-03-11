package com.satishmankar.attendance.services;

import com.satishmankar.attendance.dto.LoginRequestDTO;
import com.satishmankar.attendance.dto.LoginResponseDTO;
import com.satishmankar.attendance.dto.RegisterRequestDTO;
import com.satishmankar.attendance.dto.RegisterResponseDTO;

public interface IUserService {
    RegisterResponseDTO register(RegisterRequestDTO r);
    LoginResponseDTO login(LoginRequestDTO r);
    LoginResponseDTO login(String email, String password);
}
