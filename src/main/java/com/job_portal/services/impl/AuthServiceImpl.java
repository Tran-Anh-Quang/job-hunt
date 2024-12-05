package com.job_portal.services.impl;

import com.job_portal.dtos.LoginDTO;
import com.job_portal.dtos.UserDTO;
import com.job_portal.entities.OTP;
import com.job_portal.exceptions.JobPortalException;
import com.job_portal.repositories.OTPRepository;
import com.job_portal.repositories.UserRepository;
import com.job_portal.services.AuthService;
import com.job_portal.utilities.MailBodyContentUtilities;
import com.job_portal.utilities.Utilities;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthServiceImpl implements AuthService {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    JavaMailSender javaMailSender;
    OTPRepository otpRepository;

    @Override
    public UserDTO login(LoginDTO loginDTO) throws JobPortalException {
        var user = userRepository.findByEmail(loginDTO.getEmail())
                .orElseThrow(() -> new JobPortalException("USER_NOT_FOUND"));

        if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            throw new JobPortalException("INVALID_CREDENTIALS");
        }
        return user.toDTO();
    }

    @Override
    public Boolean sendOTP(String email) throws JobPortalException, MessagingException {
        var user =userRepository.findByEmail(email)
                .orElseThrow(() -> new JobPortalException("USER_NOT_FOUND"));

        String otp = Utilities.otpGenerator();
        OTP otpObj = new OTP(email, otp, LocalDateTime.now());
        otpRepository.save(otpObj);

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(email);
        helper.setSubject("Job Portal OTP");
        helper.setText(MailBodyContentUtilities.getMailBodyContent(otp, user.getName()), true);
        javaMailSender.send(message);
        return true;
    }

    @Override
    public Boolean verifyOTP(String email, String otp) throws JobPortalException {
        var OTPEntity = otpRepository.findById(email)
                .orElseThrow(() -> new JobPortalException("OTP_NOT_FOUND"));
        var otpExpiryTime = OTPEntity.getTimeStamp().plusMinutes(5);
        if (otpExpiryTime.isBefore(LocalDateTime.now())) {
            throw new JobPortalException("OTP_EXPIRED");
        } else if (!OTPEntity.getOtp().equals(otp)) {
            throw new JobPortalException("INVALID_OTP");
        }
        otpRepository.delete(OTPEntity);
        return true;
    }
}
