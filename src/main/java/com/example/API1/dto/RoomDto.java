package com.example.API1.dto;

import com.example.API1.models.Room;

public class RoomDto {
    private Long id;
    private String roomNumber;
    private Long reservationId; // Only storing the ID of the reservation

    // Default constructor
    public RoomDto() {
    }

    // Constructor to convert from Entity to DTO
    public RoomDto(Room room) {
        this.id = room.getId();
        this.roomNumber = room.getRoomNumber();
        this.reservationId = (room.getReservation() != null) ? room.getReservation().getId() : null;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
}
