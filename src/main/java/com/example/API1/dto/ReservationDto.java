package com.example.API1.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.API1.models.Reservation;

public class ReservationDto {
    private Long id;
    private LocalDate startDay;
    private LocalDate finishDay;
    private Long customerId;
    private Long employeeId;
    private List<Long> roomIds = new ArrayList<>();
    private Long paymentId;

    // Default constructor
    public ReservationDto() {
    }

    // Constructor to convert Reservation entity to DTO
    public ReservationDto(Reservation reservation) {
        this.id = reservation.getId();
        this.startDay = reservation.getStart_day();
        this.finishDay = reservation.getFinish_day();
        this.customerId = reservation.getCustomer().getId();
        this.employeeId = reservation.getEmployee().getId();
        this.paymentId = (reservation.getPayment() != null) ? reservation.getPayment().getId() : null;

        // Evitar NullPointerException asegurando que la lista nunca sea null
        this.roomIds = (reservation.getRooms() != null) ? 
                        reservation.getRooms().stream()
                                   .map(room -> room.getId())
                                   .collect(Collectors.toList()) 
                        : new ArrayList<>();
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }

    public LocalDate getFinishDay() {
        return finishDay;
    }

    public void setFinishDay(LocalDate finishDay) {
        this.finishDay = finishDay;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public List<Long> getRoomIds() {
        return roomIds;
    }

    public void setRoomIds(List<Long> roomIds) {
        this.roomIds = (roomIds != null) ? roomIds : new ArrayList<>();
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }
}
