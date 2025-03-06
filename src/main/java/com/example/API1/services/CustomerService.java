package com.example.API1.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.API1.dto.CustomerDto;
import com.example.API1.models.Customer;
import com.example.API1.repository.CustomersRepository;

@Service
public class CustomerService {
    
    @Autowired
    private CustomersRepository customersRepository;

    // Get method to retrieve customers
    public List<CustomerDto> findAll() {
        List<CustomerDto> customerToReturn = new ArrayList<>();
        List<Customer> customers = customersRepository.findAll();

        // Convert each Customer to CustomerDto
        for (Customer customer : customers) {
            CustomerDto customerDtoGet = new CustomerDto(customer);
            customerToReturn.add(customerDtoGet);
        }
        return customerToReturn;
    }

    // Post method to create Customers
    public CustomerDto saveCustomer(CustomerDto request) {
        Customer customer = new Customer();
        customer.setName(request.getName());

        // Save entity to the db
        Customer saveCustomer = customersRepository.save(customer);

        // Convert saved entity back to Dto and return it
        return new CustomerDto(saveCustomer);
    }

    // Delete method to delete Customers
    public String deleteCustomer(Long id) {
        if (customersRepository.existsById(id)) {
            customersRepository.deleteById(id);
            return "Customer successfully deleted";
        } else {
            return "Customer not found";
        }
    }

    // **PUT method to update Customer**
    public CustomerDto updateCustomer(Long id, CustomerDto request) {
        return customersRepository.findById(id)
            .map(existingCustomer -> {
                existingCustomer.setName(request.getName());
                Customer updatedCustomer = customersRepository.save(existingCustomer);
                return new CustomerDto(updatedCustomer);
            }).orElseThrow(() -> new RuntimeException("Customer not found with ID: " + id));
    }
}

