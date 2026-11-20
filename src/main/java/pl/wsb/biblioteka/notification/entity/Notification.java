package pl.wsb.biblioteka.notification.entity;

import jakarta.persistence.*;
import pl.wsb.biblioteka.account.domain.UserAccount;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_account_id", nullable = false)
    private UserAccount user;

    @Column(name = "message", nullable = false, length = 500)
    private String message;

    @Column(name = "template", nullable = false, length = 60)
    private String template;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    protected Notification() {
    }

    public Notification(String message, String template, LocalDateTime createdAt) {
        this.message = message;
        this.template = template;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
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
