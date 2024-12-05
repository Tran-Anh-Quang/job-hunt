package com.job_portal.apis;

import com.job_portal.dtos.LoginDTO;
import com.job_portal.dtos.ResponseDTO;
import com.job_portal.dtos.UserDTO;
import com.job_portal.exceptions.JobPortalException;
import com.job_portal.services.AuthService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthAPI {
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody @Valid LoginDTO loginDTO) throws JobPortalException {
        var res = authService.login(loginDTO);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/send-otp/{email}")
    public ResponseEntity<ResponseDTO> sendOTP(
            @PathVariable @Email(message = "{user.email.invalid}") String email
    ) throws JobPortalException, MessagingException {
        authService.sendOTP(email);
        return new ResponseEntity<>(new ResponseDTO("OTP has been sent"), HttpStatus.OK);
    }

    @GetMapping("/verify-otp/{email}/{otp}")
    public ResponseEntity<ResponseDTO> verifyOTP(
            @PathVariable @Email(message = "{user.email.invalid}") String email,
            @PathVariable @Pattern(regexp = "^[0-9]{6}$", message = "{user.otp.invalid}") String otp
    ) throws JobPortalException {
        authService.verifyOTP(email, otp);
        return new ResponseEntity<>(new ResponseDTO("OTP has been verified"), HttpStatus.OK);
    }
}
