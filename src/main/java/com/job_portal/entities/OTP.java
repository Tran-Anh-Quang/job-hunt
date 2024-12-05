package com.job_portal.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "otp")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OTP {
    @Id
    String email;
    String otp;
    LocalDateTime timeStamp;
}
