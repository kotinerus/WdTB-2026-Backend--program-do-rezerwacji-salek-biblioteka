package pl.wsb.biblioteka.room.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Salka do rezerwacji. Na razie bez klucza obcego do {@link Building}: relacja dojdzie na kolejnych zajęciach.
 */
@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 60)
    private String name;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @Column(name = "floor", nullable = false)
    private int floor;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_type", nullable = false, length = 20)
    private RoomType type;

    protected Room() {
    }

    public Room(String name, int capacity, int floor, RoomType type) {
        this.name = name;
        this.capacity = capacity;
        this.floor = floor;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getFloor() {
        return floor;
    }

    public RoomType getType() {
        return type;
    }
}
