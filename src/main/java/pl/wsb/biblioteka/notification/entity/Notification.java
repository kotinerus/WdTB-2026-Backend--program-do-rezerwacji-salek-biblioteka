package pl.wsb.biblioteka.notification.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

/**
 * Powiadomienie dla użytkownika (na razie zamockowane). Adresat to e-mail z {@code UserAccount}, bez klucza obcego:
 * relacja dojdzie na kolejnych zajęciach.
 */
@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_to", nullable = false, length = 120)
    private String userTo;

    @Column(name = "message", nullable = false, length = 500)
    private String message;

    @Column(name = "template", nullable = false, length = 60)
    private String template;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    protected Notification() {
    }

    public Notification(String userTo, String message, String template, LocalDateTime createdAt) {
        this.userTo = userTo;
        this.message = message;
        this.template = template;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getUserTo() {
        return userTo;
    }

    public String getMessage() {
        return message;
    }

    public String getTemplate() {
        return template;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
