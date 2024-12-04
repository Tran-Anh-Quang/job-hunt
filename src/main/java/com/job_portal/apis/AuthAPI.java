package com.job_portal.apis;

import com.job_portal.dtos.LoginDTO;
import com.job_portal.dtos.UserDTO;
import com.job_portal.exceptions.JobPortalException;
import com.job_portal.services.AuthService;
import jakarta.validation.Valid;
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
    public ResponseEntity<String> sendOTP(@PathVariable String email) throws JobPortalException {
        var res = authService.sendOTP(email);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
