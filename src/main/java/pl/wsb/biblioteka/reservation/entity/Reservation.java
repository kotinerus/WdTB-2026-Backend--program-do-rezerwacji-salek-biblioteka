package pl.wsb.biblioteka.reservation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
