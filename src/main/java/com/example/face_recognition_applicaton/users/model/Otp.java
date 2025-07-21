package com.example.face_recognition_applicaton.users.model;


import java.time.LocalDateTime;

import com.example.face_recognition_applicaton.users.enums.Purpose;
import com.example.face_recognition_applicaton.users.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "otp_verifications")
public class Otp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String otp;

    @Column(nullable = false)
    private LocalDateTime expiryTime;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss a EEEE")
    private LocalDateTime createdAt;
    
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss a EEEE")
    private LocalDateTime verifiedAt;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status; // PENDING, VERIFIED, EXPIRED

    @Enumerated(EnumType.STRING)
    private Purpose purpose; // e.g., REGISTER, RESET_PASSWORD, LOGIN_OTP

    private String ipAddress; // optional tracking

    private String userAgent; // browser/device info

    private int attempts; // retry count
}

