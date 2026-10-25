package pl.wsb.biblioteka.room.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Budynek, w którym mogą znajdować się salki. Na razie bez relacji z {@link Room}: dojdzie na kolejnych zajęciach.
 */
@Entity
@Table(name = "building")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @Column(name = "address", nullable = false, length = 120)
    private String address;

    @Column(name = "city", nullable = false, length = 60)
    private String city;

    @Column(name = "postal_code", nullable = false, length = 10)
    private String postalCode;

    protected Building() {
    }

    public Building(String name, String address, String city, String postalCode) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
