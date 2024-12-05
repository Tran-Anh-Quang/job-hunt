package com.job_portal.dtos;

import com.job_portal.entities.Job;
import com.job_portal.enums.JobStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JobDTO {
    Long id;
    String jobTitle;
    String company;
    List<Applicant> applicants;
    String about;
    String experience;
    String jobType;
    String location;
    Long packageOffered;
    LocalDateTime postedOn;
    String description;
    List<String> skills;
    JobStatus jobStatus;

    public Job toEntity() {
        return new Job(id, jobTitle, company, applicants, about, experience,
                jobType, location, packageOffered, postedOn, description, skills, jobStatus);
    }
}
