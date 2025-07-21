package com.example.face_recognition_applicaton.users.dto;

import com.example.face_recognition_applicaton.users.enums.Gender;
import com.example.face_recognition_applicaton.users.enums.Position;
import com.example.face_recognition_applicaton.users.enums.Role;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class UserRegistrationRequestDTO {

    @NotBlank
    @Size(max = 50)
    private String firstName;

    @NotBlank
    @Size(max = 50)
    private String lastName;

    @Email
    @NotBlank
    @Size(max = 100)
    private String email;

    @NotBlank
    @Size(min = 8, max = 255)
    private String password;

    @NotNull
    private Role role;

    @Past
    @NotNull
    private LocalDate dateOfBirth;

    @NotBlank
    @Pattern(regexp = "^\\+[0-9]{1,4}$")
    private String countryCode;

    @NotBlank
    @Size(max = 20)
    private String phoneNumber;

    @PastOrPresent
    @NotNull
    private LocalDate hireDate;

    @NotNull
    @Positive
    private BigDecimal salary;

    @NotBlank
    @Size(max = 50)
    private String employeeId;

    @NotNull
    private Position position;

    @NotBlank
    @Size(max = 100)
    private String emergencyContactName;

    private String emergencyCountryCode;

    private String emergencyContactNumber;

    @NotBlank
    @Size(max = 100)
    private String nationality;

    @NotNull
    private Gender gender;
}
