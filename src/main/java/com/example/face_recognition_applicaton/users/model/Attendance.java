package com.example.face_recognition_applicaton.users.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "attendance")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private Users user;

    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss a EEEE")
    private LocalDateTime clockInTime;
    
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss a EEEE")
    private LocalDateTime clockOutTime;
    
    
    private String deviceType;
    private String location;
    private String shiftType;
    private Double totalWorkingHours;
    private Boolean isLate;
    private String remarks;

    @Version
    private Long version;
}