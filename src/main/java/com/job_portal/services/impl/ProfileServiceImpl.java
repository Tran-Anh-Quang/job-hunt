package com.job_portal.services.impl;

import com.job_portal.dtos.ProfileDTO;
import com.job_portal.entities.Profile;
import com.job_portal.exceptions.JobPortalException;
import com.job_portal.repositories.ProfileRepository;
import com.job_portal.services.ProfileService;
import com.job_portal.utilities.Utilities;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProfileServiceImpl implements ProfileService {
    ProfileRepository profileRepository;

    @Override
    public Long createProfile(String email) throws JobPortalException {
        var profile =  Profile.builder()
                .id(Utilities.getNextSequence("profile"))
                .email(email)
                .skills(new ArrayList<>())
                .experience(new ArrayList<>())
                .certification(new ArrayList<>())
                .build();
        profileRepository.save(profile);
        return profile.getId();
    }

    @Override
    public ProfileDTO getProfile(Long profileId) throws JobPortalException {
        var profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new JobPortalException("PROFILE_NOT_FOUND"));
        return profile.toDTO();
    }

    @Override
    public ProfileDTO updateProfile(ProfileDTO profileDTO) throws JobPortalException {
        profileRepository.findById(profileDTO.getId())
                .orElseThrow(() -> new JobPortalException("PROFILE_NOT_FOUND"));
        profileRepository.save(profileDTO.toEntity());
        return profileDTO;
    }
}
