package com.job_portal.apis;

import com.job_portal.dtos.ResponseDTO;
import com.job_portal.entities.Notification;
import com.job_portal.exceptions.JobPortalException;
import com.job_portal.services.NotificationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1/notifications")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NotificationAPI {
    NotificationService notificationService;

    @GetMapping("/get/{userId}")
    public ResponseEntity<List<Notification>> getNotifications(@PathVariable Long userId) {
        return new ResponseEntity<>(notificationService.getUnreadNotifications(userId), HttpStatus.OK);
    }

    @PutMapping("/read/{notificationId}")
    public ResponseEntity<ResponseDTO> readNotification(@PathVariable Long notificationId) throws JobPortalException {
        return new ResponseEntity<>(new ResponseDTO("Notification marked as read"), HttpStatus.OK);
    }
}
