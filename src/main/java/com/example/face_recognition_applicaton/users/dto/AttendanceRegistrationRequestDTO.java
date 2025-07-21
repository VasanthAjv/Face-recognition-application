package com.example.face_recognition_applicaton.users.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AttendanceRegistrationRequestDTO {
    private String deviceType;
    private String location;
    private String shiftType;
    private String remarks;
}

