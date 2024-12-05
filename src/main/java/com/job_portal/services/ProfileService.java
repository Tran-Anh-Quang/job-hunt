package com.job_portal.services;

import com.job_portal.dtos.ProfileDTO;
import com.job_portal.exceptions.JobPortalException;

public interface ProfileService {
    Long createProfile(String email) throws JobPortalException;

    ProfileDTO getProfile(Long profileId) throws JobPortalException;

    ProfileDTO updateProfile(ProfileDTO profileDTO) throws JobPortalException;
}
