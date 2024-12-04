package com.job_portal.utilities;

import java.time.LocalDateTime;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ErrorInfo {
    String errorMessage;
    Integer errorCode;
    LocalDateTime timeStamp;

    public ErrorInfo(String errorMessage, Integer errorCode, LocalDateTime timeStamp) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.timeStamp = timeStamp;
    }
    ;
}
