package com.satishmankar.attendance.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.satishmankar.attendance.enums.GenderEnum;
import com.satishmankar.attendance.enums.UserRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity @NoArgsConstructor @AllArgsConstructor @Data
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String contact;
    @JsonIgnore
    private String password;
    private String aadharNumber;
    private GenderEnum gender;
    private String address;
    private String empId;
    private UserRoleEnum role;
    private LocalDateTime createdOn;
    private String uniqueCode;
    private Boolean active;

    @PrePersist
    public void setDefaultValues() {
        createdOn = LocalDateTime.now();
        active = true;
    }
}
