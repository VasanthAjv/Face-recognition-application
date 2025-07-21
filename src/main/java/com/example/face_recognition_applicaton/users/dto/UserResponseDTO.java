package com.example.face_recognition_applicaton.users.dto;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.face_recognition_applicaton.users.enums.Gender;
import com.example.face_recognition_applicaton.users.enums.Position;
import com.example.face_recognition_applicaton.users.enums.Role;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDTO {
    
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private Role role;

    private LocalDate dateOfBirth;

    private String countryCode;

    private String phoneNumber;

    private LocalDate hireDate;

    private BigDecimal salary;

    private String employeeId;

    private Position position;

    private String emergencyContactName;

    private String emergencyCountryCode;

    private String emergencyContactNumber;

    private String nationality;

    private Gender gender;

    private Boolean active;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
