package pl.wsb.biblioteka.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;


    public User(final int id, final String login, final String firstName, final String lastName, final String email, final Role role) {
        this.id = id;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
    }
}
