package com.notification.backend.backend.controller;

import com.notification.backend.backend.model.Notification;
import com.notification.backend.backend.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    @Autowired
    private NotificationRepository notificationRepository;

    @GetMapping
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Notification getNotificationById(@PathVariable Long id) {
        return notificationRepository.findById(id).orElseThrow(() -> new RuntimeException("Notification not found."));
    }

    @PostMapping
    public Notification createNotification(@RequestBody Notification notification) {
        notification.setSentAt(LocalDateTime.now());
        return notificationRepository.save(notification);
    }

    @PutMapping("/{id}/read")
    public Notification markAsRead(@PathVariable Long id) {
        Notification notification = notificationRepository.findById(id).orElseThrow(() -> new RuntimeException("Notification not found."));
        notification.setRead(true);
        return notificationRepository.save(notification);
    }
}
