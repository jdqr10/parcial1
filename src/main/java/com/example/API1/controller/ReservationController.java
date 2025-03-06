package com.example.API1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.API1.dto.ReservationDto;
import com.example.API1.services.ReservationService;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    // Retrieve all reservations
    @GetMapping("/getReservations")
    public List<ReservationDto> getAllReservations() {
        return reservationService.findAll();
    }

    // Save a new reservation
    @PostMapping("/saveReservation")
    public ReservationDto saveReservation(@RequestBody ReservationDto request) {
        return reservationService.saveReservation(request);
    }

    // Delete a reservation by its ID
    @DeleteMapping("/deleteReservation/{id}")
    public String deleteReservation(@PathVariable Long id) {
        return reservationService.deleteReservation(id);
    }

    // Update an existing reservation
    @PutMapping("/updateReservation/{id}")
    public ReservationDto updateReservation(@PathVariable Long id, @RequestBody ReservationDto request) {
        return reservationService.updateReservation(id, request);
    }

}
