package pl.wsb.biblioteka.reservation.entity;

import jakarta.persistence.*;
import pl.wsb.biblioteka.account.domain.UserAccount;
import pl.wsb.biblioteka.room.entity.Room;

import java.time.LocalDateTime;

/**
 * Rezerwacja salki w danym przedziale czasu.
 *
 * <p>Na razie bez kluczy obcych do salki i użytkownika ({@code UserAccount}): relacje dojdą na kolejnych zajęciach.
 */
@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private ReservationStatus status;

    @Column(name = "note", length = 200)
    private String note;

    @Embedded
    private ModificationInfo modification;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_account_id", nullable = false)
    private UserAccount user;

    protected Reservation() {
    }

    public Reservation(LocalDateTime startTime, LocalDateTime endTime, ReservationStatus status, String note,
                       ModificationInfo modification) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.note = note;
        this.modification = modification;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public String getNote() {
        return note;
    }

    public ModificationInfo getModification() {
        return modification;
    }
}
