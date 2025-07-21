package com.example.face_recognition_applicaton.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.face_recognition_applicaton.users.model.Attendance;
import com.example.face_recognition_applicaton.users.model.Users;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    Attendance findByUserAndClockOutTimeIsNull(Users user);
}