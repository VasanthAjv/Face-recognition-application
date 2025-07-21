package com.example.face_recognition_applicaton.users.dto;


import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class AttendanceResponseDTO {
    private Long id;
    
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
}

