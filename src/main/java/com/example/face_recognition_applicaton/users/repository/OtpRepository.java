package com.example.face_recognition_applicaton.users.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.face_recognition_applicaton.users.model.Otp;


public interface OtpRepository extends JpaRepository<Otp, Long> {

    Optional<Otp> findTopByEmailOrderByCreatedAtDesc(String email);

    Optional<Otp> findByEmailAndOtp(String email, String otp);

    List<Otp> findByExpiryTimeBefore(LocalDateTime time);

    List<Otp> findByEmailAndCreatedAtAfter(String email, LocalDateTime after);

    void deleteByExpiryTimeBefore(LocalDateTime time);
    
    Optional<Otp> findTopByEmailAndOtpOrderByCreatedAtDesc(String email, String otpCode);
}
