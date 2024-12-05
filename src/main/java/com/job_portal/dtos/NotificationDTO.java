package com.job_portal.dtos;

import com.job_portal.entities.Notification;
import com.job_portal.enums.NotificationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDTO {
    Long id;
    Long userId;
    String message;
    String action;
    String route;
    LocalDateTime timeStamp;
    NotificationStatus notificationStatus;

    public Notification toEntity() {
        return new Notification(id, userId, message, action, route, timeStamp, notificationStatus);
    }
}
