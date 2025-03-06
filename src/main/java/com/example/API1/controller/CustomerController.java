package com.example.API1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.API1.dto.CustomerDto;
import com.example.API1.services.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;

    // Retrieves all customers
    @GetMapping("/getCustomers")
    public List<CustomerDto> getAllCustomers(){
        return customerService.findAll();
    }

    // Save a new customer 
    @PostMapping("/saveCustomers")
    public CustomerDto saveCustomer(@RequestBody CustomerDto request){
        return customerService.saveCustomer(request);
    }

    // Update an existing customer
    @PutMapping("/updateCustomer/{id}")
    public CustomerDto updateCustomer(@PathVariable Long id, @RequestBody CustomerDto request){
        return customerService.updateCustomer(id, request);
    }

    // Delete customer by its id
    @DeleteMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable Long id){
        return customerService.deleteCustomer(id);
    }
}
