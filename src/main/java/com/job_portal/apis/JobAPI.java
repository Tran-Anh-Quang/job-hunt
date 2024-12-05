package com.job_portal.apis;

import com.job_portal.dtos.JobDTO;
import com.job_portal.exceptions.JobPortalException;
import com.job_portal.services.JobService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1/jobs")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JobAPI {
    JobService jobService;

    @PostMapping("/post")
    public ResponseEntity<JobDTO> jobPost(@RequestBody @Valid JobDTO jobDTO) throws JobPortalException {
        return new ResponseEntity<>(jobService.jobPost(jobDTO), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<JobDTO>> getAllJobs() throws JobPortalException {
        return new ResponseEntity<>(jobService.getAllJobs(), HttpStatus.OK);
    }

    @GetMapping("/get/{jobId}")
    public ResponseEntity<JobDTO> getJob(@PathVariable Long jobId) throws JobPortalException {
        return new ResponseEntity<>(jobService.getJob(jobId), HttpStatus.OK);
    }
}
