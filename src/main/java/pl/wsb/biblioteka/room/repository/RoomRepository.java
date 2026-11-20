package pl.wsb.biblioteka.room.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.biblioteka.room.entity.Room;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByBuilding_City(String city);
}