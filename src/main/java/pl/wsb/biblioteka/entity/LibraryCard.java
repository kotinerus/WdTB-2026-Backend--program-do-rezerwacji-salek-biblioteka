package pl.wsb.biblioteka.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import pl.wsb.biblioteka.account.domain.UserAccount;

import java.time.LocalDate;

@Entity
@Table(name = "library_card")
public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "card_number", nullable = false, unique = true, length = 20)
    private String cardNumber;

    @Column(name = "issued_at", nullable = false)
    private LocalDate issuedAt;

    @Column(name = "expires_at", nullable = false)
    private LocalDate expiresAt;

    @Column(name = "active", nullable = false)
    private boolean active;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_account_id", nullable = false, unique = true)
    private UserAccount user;

    protected LibraryCard() {
    }

    public LibraryCard(String cardNumber, LocalDate issuedAt, LocalDate expiresAt, boolean active, UserAccount user) {
        this.cardNumber = cardNumber;
        this.issuedAt = issuedAt;
        this.expiresAt = expiresAt;
        this.active = active;
        this.user = user;
    }

    public Long getId() { return id; }
    public String getCardNumber() { return cardNumber; }
    public LocalDate getIssuedAt() { return issuedAt; }
    public LocalDate getExpiresAt() { return expiresAt; }
    public boolean isActive() { return active; }
    public UserAccount getUser() { return user; }
}