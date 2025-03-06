package com.example.API1.dto;

import com.example.API1.models.Payment;

public class PaymentDto {
    private Long id;
    private Double value;
    private Long reservationId; // Reference to the associated reservation

    // Empty constructor (required for frameworks like Jackson)
    public PaymentDto() {
    }

    // Constructor to convert from Payment entity to DTO
    public PaymentDto(Payment payment) {
        this.id = payment.getId();
        this.value = payment.getValue();
        this.reservationId = payment.getReservation().getId();
    }

    // Getter and Setter for ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for Value
    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    // Getter and Setter for Reservation ID
    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
}
