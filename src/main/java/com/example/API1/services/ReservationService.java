package com.example.API1.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.API1.dto.ReservationDto;
import com.example.API1.models.Customer;
import com.example.API1.models.Employee;
import com.example.API1.models.Reservation;
import com.example.API1.models.Room;
import com.example.API1.repository.CustomersRepository;
import com.example.API1.repository.EmployeesRepository;
import com.example.API1.repository.ReservationsRepository;
import com.example.API1.repository.RoomsRepository;

@Service
public class ReservationService {

    @Autowired
    private ReservationsRepository reservationsRepository;

    @Autowired
    private CustomersRepository customersRepository;

    @Autowired
    private EmployeesRepository employeesRepository;

    @Autowired
    private RoomsRepository roomsRepository;

    // Retrieve all reservations
    public List<ReservationDto> findAll() {
        List<ReservationDto> reservationsToReturn = new ArrayList<>();
        List<Reservation> reservations = reservationsRepository.findAll();

        // Convert each Reservation entity to DTO
        for (Reservation reservation : reservations) {
            reservationsToReturn.add(new ReservationDto(reservation));
        }
        return reservationsToReturn;
    }

    // Save a new reservation
    public ReservationDto saveReservation(ReservationDto request) {
        Reservation reservation = new Reservation();
        reservation.setStart_day(request.getStartDay());
        reservation.setFinish_day(request.getFinishDay());

        // Fetch and set Customer
        Optional<Customer> customerOpt = customersRepository.findById(request.getCustomerId());
        if (customerOpt.isPresent()) {
            reservation.setCustomer(customerOpt.get());
        } else {
            throw new RuntimeException("Customer not found");
        }

        // Fetch and set Employee
        Optional<Employee> employeeOpt = employeesRepository.findById(request.getEmployeeId());
        if (employeeOpt.isPresent()) {
            reservation.setEmployee(employeeOpt.get());
        } else {
            throw new RuntimeException("Employee not found");
        }

        // Fetch and set Rooms
        List<Room> rooms = request.getRoomIds().stream()
                .map(roomId -> roomsRepository.findById(roomId)
                        .orElseThrow(() -> new RuntimeException("Room not found")))
                .collect(Collectors.toList());
        reservation.setRooms(rooms);

        // Save the entity to the database
        Reservation savedReservation = reservationsRepository.save(reservation);

        // Convert saved entity back to DTO and return it
        return new ReservationDto(savedReservation);
    }

    // Delete a reservation by ID
    public String deleteReservation(Long id) {
        if (reservationsRepository.existsById(id)) {
            reservationsRepository.deleteById(id);
            return "Reservation successfully deleted";
        } else {
            return "Reservation not found";
        }
    }

    // Update an existing reservation
    public ReservationDto updateReservation(Long id, ReservationDto request) {
        Optional<Reservation> reservationOpt = reservationsRepository.findById(id);

        if (reservationOpt.isPresent()) {
            Reservation reservation = reservationOpt.get();
            reservation.setStart_day(request.getStartDay());
            reservation.setFinish_day(request.getFinishDay());

            // Fetch and update Customer
            Optional<Customer> customerOpt = customersRepository.findById(request.getCustomerId());
            if (customerOpt.isPresent()) {
                reservation.setCustomer(customerOpt.get());
            } else {
                throw new RuntimeException("Customer not found");
            }

            // Fetch and update Employee
            Optional<Employee> employeeOpt = employeesRepository.findById(request.getEmployeeId());
            if (employeeOpt.isPresent()) {
                reservation.setEmployee(employeeOpt.get());
            } else {
                throw new RuntimeException("Employee not found");
            }

            // Fetch and update Rooms
            List<Room> rooms = request.getRoomIds().stream()
                    .map(roomId -> roomsRepository.findById(roomId)
                            .orElseThrow(() -> new RuntimeException("Room not found")))
                    .collect(Collectors.toList());
            reservation.setRooms(rooms);

            // Save updated entity to the database
            Reservation updatedReservation = reservationsRepository.save(reservation);

            // Convert updated entity back to DTO and return it
            return new ReservationDto(updatedReservation);
        } else {
            throw new RuntimeException("Reservation not found");
        }
    }

}
