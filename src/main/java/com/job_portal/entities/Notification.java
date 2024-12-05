package com.job_portal.entities;

import com.job_portal.dtos.NotificationDTO;
import com.job_portal.enums.NotificationStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "notification")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Notification {
    @Id
    Long id;
    Long userId;
    String message;
    String action;
    String route;
    LocalDateTime timeStamp;
    NotificationStatus notificationStatus;

    public NotificationDTO toDTO() {
        return new NotificationDTO(id, userId, message, action, route, timeStamp, notificationStatus);
    }
}
