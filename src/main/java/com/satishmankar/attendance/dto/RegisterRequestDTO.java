package com.satishmankar.attendance.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.satishmankar.attendance.enums.GenderEnum;
import com.satishmankar.attendance.enums.UserRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDTO {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String email;
    private String contact;
    @NotBlank
    private String password;
    @NotBlank
    private String  confirmPassword;
    @NotBlank
    private String aadharNumber;
    @NotBlank
    private GenderEnum gender;
    @NotBlank
    private String address;
    @NotBlank
    private String empId;
    @NotBlank
    private UserRoleEnum role;

}
