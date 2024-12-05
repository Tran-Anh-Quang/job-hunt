package com.job_portal.services;

import com.job_portal.dtos.LoginDTO;
import com.job_portal.dtos.UserDTO;
import com.job_portal.exceptions.JobPortalException;
import jakarta.mail.MessagingException;

public interface AuthService {
    UserDTO login(LoginDTO loginDTO) throws JobPortalException;

    Boolean sendOTP(String email) throws JobPortalException, MessagingException;

    Boolean verifyOTP(String email, String otp) throws JobPortalException;
}
