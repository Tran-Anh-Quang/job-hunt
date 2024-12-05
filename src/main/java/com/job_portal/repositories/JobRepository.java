package com.job_portal.repositories;

import com.job_portal.entities.Job;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface JobRepository extends MongoRepository<Job, Long> {
    List<Job> findByPostedBy(Long postedBy);
}
