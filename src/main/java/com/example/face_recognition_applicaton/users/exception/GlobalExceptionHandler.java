package com.example.face_recognition_applicaton.users.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	    @ExceptionHandler(OtpDeliveryException.class)
	    public ResponseEntity<String> handleOtpDeliveryException(OtpDeliveryException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	    }
}
