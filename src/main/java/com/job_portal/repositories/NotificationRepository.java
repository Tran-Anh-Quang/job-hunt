package com.job_portal.repositories;

import com.job_portal.entities.Notification;
import com.job_portal.enums.NotificationStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NotificationRepository extends MongoRepository<Notification, Long> {
    List<Notification> findByUserIdAndNotificationStatus(Long userId, NotificationStatus notificationStatus);
}
