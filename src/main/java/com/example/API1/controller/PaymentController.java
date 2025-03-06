package com.example.API1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.API1.dto.PaymentDto;
import com.example.API1.services.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Retrieves all payments
    @GetMapping("/getPayments")
    public List<PaymentDto> getAllPayments() {
        return paymentService.findAll();
    }

    // Save a new payment
    @PostMapping("/savePayment")
    public PaymentDto savePayment(@RequestBody PaymentDto request) {
        return paymentService.savePayment(request);
    }

    // Delete a payment by its ID
    @DeleteMapping("/deletePayment/{id}")
    public String deletePayment(@PathVariable Long id) {
        return paymentService.deletePayment(id);
    }

    // Update an existing payment
    @PutMapping("/updatePayment/{id}")
    public PaymentDto updatePayment(@PathVariable Long id, @RequestBody PaymentDto request) {
        return paymentService.updatePayment(id, request);
    }

}
