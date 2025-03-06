
package com.example.API1.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.API1.models.Payment;


@Repository
public interface PaymentsRepository extends JpaRepository<Payment, Long> {
}
