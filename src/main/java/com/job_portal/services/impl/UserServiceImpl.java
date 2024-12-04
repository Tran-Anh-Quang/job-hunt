package com.job_portal.services.impl;

import com.job_portal.dtos.UserDTO;
import com.job_portal.entities.User;
import com.job_portal.exceptions.JobPortalException;
import com.job_portal.repositories.UserRepository;
import com.job_portal.services.UserService;
import com.job_portal.utilities.Utilities;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service(value = "userService")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    @Override
    public UserDTO registeredUser(UserDTO userDTO) throws JobPortalException {
        Optional<User> userOtp = userRepository.findByEmail(userDTO.getEmail());
        if (userOtp.isPresent()) {
            throw new JobPortalException("USER_FOUND");
        }
        userDTO.setId(Utilities.getNextSequence("user"));
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        var user = userDTO.toEntity();
        user = userRepository.save(user);
        return user.toDTO();
    }
}
