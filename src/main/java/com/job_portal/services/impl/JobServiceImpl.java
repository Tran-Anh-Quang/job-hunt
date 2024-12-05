package com.job_portal.services.impl;

import com.job_portal.dtos.JobDTO;
import com.job_portal.entities.Job;
import com.job_portal.exceptions.JobPortalException;
import com.job_portal.repositories.JobRepository;
import com.job_portal.services.JobService;
import com.job_portal.utilities.Utilities;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JobServiceImpl implements JobService {
    JobRepository jobRepository;

    @Override
    public JobDTO jobPost(JobDTO jobDTO) throws JobPortalException {
        jobDTO.setId(Utilities.getNextSequence("job"));
        jobDTO.setPostedOn(LocalDateTime.now());
        return jobRepository.save(jobDTO.toEntity()).toDTO();
    }

    @Override
    public List<JobDTO> getAllJobs() throws JobPortalException {
        return jobRepository.findAll().stream().map(Job::toDTO).toList();
    }

    @Override
    public JobDTO getJob(Long jobId) throws JobPortalException {
        return jobRepository.findById(jobId).map(Job::toDTO).orElseThrow(() -> new JobPortalException("JOB_NOT_FOUND"));
    }

}
