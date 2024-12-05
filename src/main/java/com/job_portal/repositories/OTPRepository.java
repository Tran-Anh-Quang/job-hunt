package com.job_portal.repositories;

import com.job_portal.entities.OTP;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OTPRepository extends MongoRepository<OTP, String> {
}
