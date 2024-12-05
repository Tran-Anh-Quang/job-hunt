package com.job_portal.entities;

import com.job_portal.dtos.ApplicantDTO;
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
public class Applicant {
    Long applicantId;
    String name;
    String email;
    String phone;
    String website;
    byte[] resume;
    String coverLetter;
    LocalDateTime appliedOn;
    ApplicationStatus applicationStatus;
    LocalDateTime interviewDate;

    public ApplicantDTO toDTO() {
        return new ApplicantDTO(applicantId, name, email, phone, website,
                resume!=null? Base64.getEncoder().encodeToString(resume) : null,
                coverLetter, appliedOn, applicationStatus, interviewDate);
    }
}
