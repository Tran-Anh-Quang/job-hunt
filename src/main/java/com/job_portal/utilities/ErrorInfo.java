package com.job_portal.utilities;

import java.time.LocalDateTime;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ErrorInfo {
    String errorMessage;
    Integer errorCode;
    LocalDateTime timeStamp;
}
