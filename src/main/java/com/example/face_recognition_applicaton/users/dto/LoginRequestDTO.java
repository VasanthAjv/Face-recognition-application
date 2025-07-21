package com.example.face_recognition_applicaton.users.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequestDTO {

    @NotBlank(message = "Email or Phone Number is required")
    private String emailOrPhone;

    @NotBlank(message = "Password is required")
    private String password;
}
