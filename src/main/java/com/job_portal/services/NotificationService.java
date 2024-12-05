package com.job_portal.services;

import com.job_portal.dtos.NotificationDTO;
import com.job_portal.entities.Notification;
import com.job_portal.exceptions.JobPortalException;

import java.util.List;

public interface NotificationService {
    void sendNotification(NotificationDTO notificationDTO) throws JobPortalException;

    List<Notification> getUnreadNotifications(Long userId);

    void markAsRead(Long notificationId) throws JobPortalException;
}
