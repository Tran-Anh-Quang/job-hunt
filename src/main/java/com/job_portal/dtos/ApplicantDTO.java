package com.job_portal.dtos;

import com.job_portal.entities.Applicant;
import com.job_portal.enums.ApplicationStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Base64;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApplicantDTO {
    Long applicantId;
    String name;
    String email;
    String phone;
    String website;
    String resume;
    String coverLetter;
    LocalDateTime appliedOn;
    ApplicationStatus applicationStatus;
    LocalDateTime interviewDate;

    public Applicant toEntity() {
        return new Applicant(applicantId, name, email, phone, website,
                resume!=null? Base64.getDecoder().decode(resume) : null,
                coverLetter, appliedOn, applicationStatus, interviewDate);
    }
}
