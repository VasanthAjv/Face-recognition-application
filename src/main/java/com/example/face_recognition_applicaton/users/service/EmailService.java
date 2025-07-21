package com.example.face_recognition_applicaton.users.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.face_recognition_applicaton.users.exception.OtpDeliveryException;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Async
    public CompletableFuture<Boolean> sendOtpEmail(String to, String otpCode, LocalDateTime createdAt, LocalDateTime expiryAt, String purpose) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject("Your OTP for " + purpose);

            String htmlContent = """
                <html>
                <body style='font-family: Arial, sans-serif;'>
                    <h2 style='color: #2e6c80;'>Hello from FaceRecognition!</h2>
                    <p>We're processing your request for <strong>%s</strong>.</p>

                    <p>Your One-Time Password (OTP) is:</p>
                    <h3 style='color: #e74c3c;'>%s</h3>

                    <table style='font-size: 14px; margin-top: 10px;'>
                        <tr><td><strong>Generated At:</strong></td><td>%s</td></tr>
                        <tr><td><strong>Expires At:</strong></td><td>%s</td></tr>
                        <tr><td><strong>Valid For:</strong></td><td>5 minutes</td></tr>
                    </table>

                    <p style='margin-top: 20px;'>⚠️ This OTP is confidential. Do not share it with anyone.</p>
                    <p>If you did not initiate this action, please ignore this email or contact support immediately.</p>

                    <p>Thanks & Regards,<br><strong>FaceRecognition Team</strong></p>
                </body>
                </html>
                """.formatted(
                    purpose.toUpperCase(),
                    otpCode,
                    createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                    expiryAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                );

            helper.setText(htmlContent, true);
            mailSender.send(message);
            return CompletableFuture.completedFuture(true);
        } catch (Exception e) {
            throw new OtpDeliveryException("Failed to send OTP email: " + e.getMessage(), e);
        }
    }

    @Async
    public CompletableFuture<Void> sendWelcomeEmail(String to, String fullName) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject("🎉 Welcome to FaceRecognition, " + fullName + "!");

            String htmlContent = """
                <html>
                <body style='font-family: Arial, sans-serif; background-color: #f9f9f9; padding: 20px;'>
                    <div style='max-width: 600px; margin: auto; background-color: white; padding: 20px; border-radius: 10px; box-shadow: 0 2px 5px rgba(0,0,0,0.1);'>
                        <h2 style='color: #2e6c80;'>Hi %s 👋</h2>

                        <p>Welcome to <strong>FaceRecognition System</strong>! We're excited to have you on board.</p>

                        <p>Now you're all set to experience secure, smart, and seamless face authentication.</p>

                        <hr style='border: none; border-top: 1px solid #ddd; margin: 20px 0;'>

                        <p>✅ What you can do now:</p>
                        <ul>
                            <li>Login using your credentials</li>
                            <li>Register your face image</li>
                            <li>Explore your dashboard</li>
                        </ul>

                        <p>If you ever need help, our support team is here for you.</p>

                        <p style='margin-top: 30px;'>Thanks & Regards,<br>
                        <strong>FaceRecognition Team</strong></p>

                        <p style='font-size: 12px; color: gray;'>This is an automated email. Please do not reply to this message.</p>
                    </div>
                </body>
                </html>
                """.formatted(fullName);

            helper.setText(htmlContent, true);
            mailSender.send(message);
            return CompletableFuture.completedFuture(null);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send welcome email", e);
        }
    }
}
