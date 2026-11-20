package pl.wsb.biblioteka.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.biblioteka.reservation.entity.Reservation;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByRoom_Name(String roomName);
    List<Reservation> findByUser_Email(String email);
}