package com.job_portal.services;

import com.job_portal.dtos.UserDTO;
import com.job_portal.exceptions.JobPortalException;

public interface UserService {
    UserDTO registeredUser(UserDTO userDTO) throws JobPortalException;
}
