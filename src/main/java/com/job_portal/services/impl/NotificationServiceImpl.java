package com.job_portal.services.impl;

import com.job_portal.dtos.NotificationDTO;
import com.job_portal.entities.Notification;
import com.job_portal.enums.NotificationStatus;
import com.job_portal.exceptions.JobPortalException;
import com.job_portal.repositories.NotificationRepository;
import com.job_portal.services.NotificationService;
import com.job_portal.utilities.Utilities;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NotificationServiceImpl implements NotificationService {
    NotificationRepository notificationRepository;

    @Override
    public void sendNotification(NotificationDTO notificationDTO) throws JobPortalException {
        notificationDTO.setId(Utilities.getNextSequence("notification"));
        notificationDTO.setNotificationStatus(NotificationStatus.UNREAD);
        notificationDTO.setTimeStamp(LocalDateTime.now());
        notificationRepository.save(notificationDTO.toEntity());
    }

    @Override
    public List<Notification> getUnreadNotifications(Long userId) {
        return notificationRepository.findByUserIdAndNotificationStatus(userId, NotificationStatus.UNREAD);
    }

    @Override
    public void markAsRead(Long notificationId) throws JobPortalException {
        var notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new JobPortalException("NOTIFICATION_NOT_FOUND"));
        notification.setNotificationStatus(NotificationStatus.READ);
        notificationRepository.save(notification);
    }
}
