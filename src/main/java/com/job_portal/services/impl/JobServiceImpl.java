package com.job_portal.services.impl;

import com.job_portal.dtos.ApplicantDTO;
import com.job_portal.dtos.JobDTO;
import com.job_portal.entities.Application;
import com.job_portal.entities.Job;
import com.job_portal.enums.ApplicationStatus;
import com.job_portal.enums.JobStatus;
import com.job_portal.exceptions.JobPortalException;
import com.job_portal.repositories.JobRepository;
import com.job_portal.services.JobService;
import com.job_portal.utilities.Utilities;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JobServiceImpl implements JobService {
    JobRepository jobRepository;

    @Override
    public JobDTO jobPost(JobDTO jobDTO) throws JobPortalException {
        if (jobDTO.getId() == null) {
            jobDTO.setId(Utilities.getNextSequence("job"));
            jobDTO.setPostedOn(LocalDateTime.now());
        } else {
            jobRepository.findById(jobDTO.getId())
                    .orElseThrow(() -> new JobPortalException("JOB_NOT_FOUND"));
            if (jobDTO.getJobStatus().equals(JobStatus.DRAFT) || jobDTO.getJobStatus().equals(JobStatus.CLOSED)) {
                jobDTO.setPostedOn(LocalDateTime.now());
            }
        }
        return jobRepository.save(jobDTO.toEntity()).toDTO();
    }

    @Override
    public List<JobDTO> getAllJobs() {
        return jobRepository.findAll().stream().map(Job::toDTO).toList();
    }

    @Override
    public JobDTO getJob(Long jobId) throws JobPortalException {
        return jobRepository.findById(jobId).map(Job::toDTO).orElseThrow(() -> new JobPortalException("JOB_NOT_FOUND"));
    }

    @Override
    public void applyJob(Long jobId, ApplicantDTO applicantDTO) throws JobPortalException {
        var job = jobRepository.findById(jobId).orElseThrow(() -> new JobPortalException("JOB_NOT_FOUND"));
        var applicants = job.getApplicants();
        if (applicants == null) {
            applicants = new ArrayList<>();
        }
        if (applicants.stream().anyMatch((x) -> x.getApplicantId().equals(applicantDTO.getApplicantId()))) {
            throw new JobPortalException("APPLICANT_ALREADY_APPLIED");
        }
        applicantDTO.setApplicationStatus(ApplicationStatus.APPLIED);
        applicants.add(applicantDTO.toEntity());
        job.setApplicants(applicants);
        jobRepository.save(job);
    }

    @Override
    public List<JobDTO> getJobsByPostedBy(Long postedBy) {
        return jobRepository.findByPostedBy(postedBy).stream().map(Job::toDTO).toList();
    }

    @Override
    public void changeApplicantStatus(Application application) throws JobPortalException {
        var job = jobRepository.findById(application.getId()).orElseThrow(() -> new JobPortalException("JOB_NOT_FOUND"));
        var applicants = job.getApplicants().stream().peek((x) -> {
            if (x.getApplicantId().equals(application.getApplicantId())) {
                x.setApplicationStatus(application.getApplicationStatus());
                if (application.getApplicationStatus().equals(ApplicationStatus.INTERVIEW)) {
                    x.setInterviewDate(application.getInterviewDate());
                }
            }
        }).toList();
        job.setApplicants(applicants);
        jobRepository.save(job);
    }
}
