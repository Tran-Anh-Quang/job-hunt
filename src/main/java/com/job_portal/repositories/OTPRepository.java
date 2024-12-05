package com.job_portal.repositories;

import com.job_portal.entities.OTP;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface OTPRepository extends MongoRepository<OTP, String> {
    List<OTP> findByExpiryTimeBefore(LocalDateTime expiryTime);
}
