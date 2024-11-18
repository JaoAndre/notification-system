package com.notification.backend.backend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private NotificationType type;

    @Column(nullable = false)
    private LocalDateTime sentAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User recipient;

    public enum NotificationType {
        EMAIL, SMS, PUSH
    }

    public Notification() {
    }

    public Notification(Long id, String title, String message, NotificationType type, LocalDateTime sentAt, User recipient) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.type = type;
        this.sentAt = sentAt;
        this.recipient = recipient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }
}
