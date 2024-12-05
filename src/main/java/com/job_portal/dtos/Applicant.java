package com.job_portal.dtos;

import com.job_portal.enums.ApplicationStatus;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Applicant {
    Long applicantId;
    LocalDateTime appliedOn;
    ApplicationStatus applicationStatus;
}
