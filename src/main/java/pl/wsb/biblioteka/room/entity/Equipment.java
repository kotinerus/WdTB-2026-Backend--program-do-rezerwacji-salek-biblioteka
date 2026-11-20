package pl.wsb.biblioteka.room.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 60)
    private String name;

    @Column(name = "category", nullable = false, length = 40)
    private String category;

    @Column(name = "inventory_number", nullable = false, length = 30)
    private String inventoryNumber;

    @Column(name = "active", nullable = false)
    private boolean active;

    protected Equipment() {}

    public Equipment(String name, String category, String inventoryNumber, boolean active) {
        this.name = name;
        this.category = category;
        this.inventoryNumber = inventoryNumber;
        this.active = active;
    }

    Long getId() {
        return id;
    }

    void setId(final Long id) {
        this.id = id;
    }

    String getName() {
        return name;
    }

    void setName(final String name) {
        this.name = name;
    }

    String getCategory() {
        return category;
    }

    void setCategory(final String category) {
        this.category = category;
    }

    String getInventoryNumber() {
        return inventoryNumber;
    }

    void setInventoryNumber(final String inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    boolean isActive() {
        return active;
    }

    void setActive(final boolean active) {
        this.active = active;
    }
}