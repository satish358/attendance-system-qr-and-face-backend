package com.satishmankar.attendance.dao;

import com.satishmankar.attendance.enums.UserRoleEnum;
import com.satishmankar.attendance.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
    Boolean existsByEmail(String email);
    Boolean existsByAadharNumber(String aadhar);
    Boolean existsByEmailAndActive(String email, Boolean active);
    Page<User> findAllByRole(UserRoleEnum role,
                             Pageable pageable);
    Page<User> findAllByActiveAndRole(Boolean active, UserRoleEnum role,
                             Pageable pageable);
}
