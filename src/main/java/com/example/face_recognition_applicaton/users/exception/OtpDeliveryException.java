package com.example.face_recognition_applicaton.users.exception;

public class OtpDeliveryException extends RuntimeException {
    public OtpDeliveryException(String message) {
        super(message);
    }
    public OtpDeliveryException(String message, Throwable cause) {
        super(message, cause);
    }
    private static final long serialVersionUID = 1L;
}
