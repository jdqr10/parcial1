package com.example.API1.models;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> bookingsManaged;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Reservation> getBookingsManaged() {
        return bookingsManaged;
    }

    public void setBookingsManaged(List<Reservation> bookingsManaged) {
        this.bookingsManaged = bookingsManaged;
    }
}
