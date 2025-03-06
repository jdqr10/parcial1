package com.example.API1.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.API1.dto.RoomDto;
import com.example.API1.models.Reservation;
import com.example.API1.models.Room;
import com.example.API1.repository.ReservationsRepository;
import com.example.API1.repository.RoomsRepository;

@Service
public class RoomService {

    @Autowired
    private RoomsRepository roomsRepository;

    @Autowired
    private ReservationsRepository reservationsRepository;

    // Get method to retrieve all rooms
    public List<RoomDto> findAll() {
        List<RoomDto> roomsToReturn = new ArrayList<>();
        List<Room> rooms = roomsRepository.findAll();

        // Convert each Room to RoomDto
        for (Room room : rooms) {
            RoomDto roomDtoGet = new RoomDto(room);
            roomsToReturn.add(roomDtoGet);
        }
        return roomsToReturn;
    }

    // Post method to create a new Room
    public RoomDto saveRoom(RoomDto request) {
        Room room = new Room();
        room.setRoomNumber(request.getRoomNumber());

        // Assign reservation if provided
        if (request.getReservationId() != null) {
            Optional<Reservation> optionalReservation = reservationsRepository.findById(request.getReservationId());
            optionalReservation.ifPresent(room::setReservation);
        }

        // Save entity to the database
        Room savedRoom = roomsRepository.save(room);

        // Convert saved entity back to Dto and return it
        return new RoomDto(savedRoom);
    }

    // Delete method to remove a Room by ID
    public String deleteRoom(Long id) {
        if (roomsRepository.existsById(id)) {
            roomsRepository.deleteById(id);
            return "Room successfully deleted";
        } else {
            return "Room not found";
        }
    }

    // Update an existing room
public RoomDto updateRoom(Long id, RoomDto request) {
    Optional<Room> optionalRoom = roomsRepository.findById(id);

    if (optionalRoom.isEmpty()) {
        throw new RuntimeException("Room not found");
    }

    Room room = optionalRoom.get();
    room.setRoomNumber(request.getRoomNumber());

    // Assign reservation if provided
    if (request.getReservationId() != null) {
        Optional<Reservation> optionalReservation = reservationsRepository.findById(request.getReservationId());
        optionalReservation.ifPresent(room::setReservation);
    }

    // Save updated room
    Room updatedRoom = roomsRepository.save(room);

    // Convert updated entity back to DTO and return it
    return new RoomDto(updatedRoom);
}

}
