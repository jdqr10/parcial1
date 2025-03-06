package com.example.API1.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.API1.dto.PaymentDto;
import com.example.API1.models.Payment;
import com.example.API1.models.Reservation;
import com.example.API1.repository.PaymentsRepository;
import com.example.API1.repository.ReservationsRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentsRepository paymentRepository;


    //
    public List<PaymentDto> findAll(){
        List<PaymentDto> paymetToReturn = new ArrayList<>();
        List<Payment> payments = paymentRepository.findAll();

        //
        for(Payment payment : payments){
            PaymentDto paymentDtoGet = new PaymentDto(payment);
            paymetToReturn.add(paymentDtoGet);
        }
        return paymetToReturn;
    }

    @Autowired
    private ReservationsRepository reservationsRepository;

    // POST method to create a new Payment
    public PaymentDto savePayment(PaymentDto request) {
        Optional<Reservation> optionalReservation = reservationsRepository.findById(request.getReservationId());

        if (optionalReservation.isEmpty()) {
            throw new RuntimeException("Reservation not found");
        }

        Payment payment = new Payment();
        payment.setValue(request.getValue());
        payment.setReservation(optionalReservation.get());

        // Save entity to the database
        Payment savedPayment = paymentRepository.save(payment);

        // Convert saved entity back to DTO and return it
        return new PaymentDto(savedPayment);
    }

    // DELETE method to delete a Payment
    public String deletePayment(Long id) {
        if (paymentRepository.existsById(id)) {
            paymentRepository.deleteById(id);
            return "Payment successfully deleted";
        } else {
            return "Payment not found";
        }
    }

    // Update an existing payment
public PaymentDto updatePayment(Long id, PaymentDto request) {
    Optional<Payment> optionalPayment = paymentRepository.findById(id);

    if (optionalPayment.isEmpty()) {
        throw new RuntimeException("Payment not found");
    }

    Payment payment = optionalPayment.get();
    payment.setValue(request.getValue());

    Optional<Reservation> optionalReservation = reservationsRepository.findById(request.getReservationId());
    if (optionalReservation.isPresent()) {
        payment.setReservation(optionalReservation.get());
    } else {
        throw new RuntimeException("Reservation not found");
    }

    // Save updated payment
    Payment updatedPayment = paymentRepository.save(payment);
    return new PaymentDto(updatedPayment);
}

}
