package com.job_portal.repositories;

import com.job_portal.entities.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileRepository extends MongoRepository<Profile, Long> {
}
