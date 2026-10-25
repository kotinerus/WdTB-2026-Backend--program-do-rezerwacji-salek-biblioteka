package pl.wsb.biblioteka.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Room {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //TODO
}
