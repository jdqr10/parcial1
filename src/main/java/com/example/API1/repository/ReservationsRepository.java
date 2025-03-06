
package com.example.API1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.API1.models.Reservation;  

@Repository
public interface ReservationsRepository extends JpaRepository<Reservation, Long> {
}

