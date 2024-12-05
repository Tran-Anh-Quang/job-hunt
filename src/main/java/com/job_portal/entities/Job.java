package com.job_portal.entities;

import com.job_portal.dtos.Applicant;
import com.job_portal.dtos.JobDTO;
import com.job_portal.enums.JobStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "job")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Job {
    @Id
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

    public JobDTO toDTO() {
        return new JobDTO(id, jobTitle, company, applicants, about, experience,
                jobType, location, packageOffered, postedOn, description, skills, jobStatus);
    }
}
