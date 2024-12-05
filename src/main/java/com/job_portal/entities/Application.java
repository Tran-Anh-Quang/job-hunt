package com.job_portal.entities;

import com.job_portal.enums.ApplicationStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Application {
    Long id;
    Long applicantId;
    LocalDateTime interviewDate;
    ApplicationStatus applicationStatus;
}
