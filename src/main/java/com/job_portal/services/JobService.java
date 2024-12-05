package com.job_portal.services;

import com.job_portal.dtos.JobDTO;
import com.job_portal.exceptions.JobPortalException;

import java.util.List;

public interface JobService {
    JobDTO jobPost(JobDTO jobDTO) throws JobPortalException;

    List<JobDTO> getAllJobs() throws JobPortalException;

    JobDTO getJob(Long jobId) throws JobPortalException;
}
