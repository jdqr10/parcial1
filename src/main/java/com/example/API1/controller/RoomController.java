package com.example.API1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.API1.dto.RoomDto;
import com.example.API1.services.RoomService;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    // Retrieves all rooms
    @GetMapping("/getRooms")
    public List<RoomDto> getAllRooms() {
        return roomService.findAll();
    }

    // Save a new room
    @PostMapping("/saveRoom")
    public RoomDto saveRoom(@RequestBody RoomDto request) {
        return roomService.saveRoom(request);
    }

    // Delete room by its id
    @DeleteMapping("/deleteRoom/{id}")
    public String deleteRoom(@PathVariable Long id) {
        return roomService.deleteRoom(id);
    }

    // Update an existing room
    @PutMapping("/updateRoom/{id}")
    public RoomDto updateRoom(@PathVariable Long id, @RequestBody RoomDto request) {
        return roomService.updateRoom(id, request);
    }

}
