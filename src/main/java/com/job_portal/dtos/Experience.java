package com.job_portal.dtos;

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
public class Experience {
    String title;
    String company;
    String location;
    LocalDateTime startDate;
    LocalDateTime endDate;
    Boolean working;
    String description;
}
