package com.notification.backend.backend.controller;

import com.notification.backend.backend.model.Notification;
import com.notification.backend.backend.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    @Autowired
    NotificationRepository notificationRepository;

    @GetMapping()
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @GetMapping("/id")
    public Notification getNotificationById(@PathVariable Long id) {
        return notificationRepository.findById(id).orElseThrow(() -> new RuntimeException("Notification not found. " + id));
    }

    @PostMapping()
    public Notification createNotification(@RequestBody Notification notification) {
        return notificationRepository.save(notification);
    }
}
