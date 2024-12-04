package com.job_portal.services;

import com.job_portal.dtos.LoginDTO;
import com.job_portal.dtos.UserDTO;
import com.job_portal.exceptions.JobPortalException;

public interface AuthService {
    UserDTO login(LoginDTO loginDTO) throws JobPortalException;


}
