package pl.wsb.biblioteka.room.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "building_id", nullable = false)
    private Building building;

    @ManyToMany
    @JoinTable(name = "room_equipment",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id"))
    private Set<Equipment> equipment = new HashSet<>();

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
