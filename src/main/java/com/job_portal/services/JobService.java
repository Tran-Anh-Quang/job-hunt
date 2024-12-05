package com.job_portal.services;

import com.job_portal.dtos.ApplicantDTO;
import com.job_portal.dtos.JobDTO;
import com.job_portal.entities.Application;
import com.job_portal.exceptions.JobPortalException;

import java.util.List;

public interface JobService {
    JobDTO jobPost(JobDTO jobDTO) throws JobPortalException;

    List<JobDTO> getAllJobs() throws JobPortalException;

    JobDTO getJob(Long jobId) throws JobPortalException;

    void applyJob(Long jobId, ApplicantDTO applicant) throws JobPortalException;

    List<JobDTO> getJobsByPostedBy(Long postedBy) throws JobPortalException;

    void changeApplicantStatus(Application application) throws JobPortalException;
}
