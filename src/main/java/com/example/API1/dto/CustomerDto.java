package com.example.API1.dto;

import com.example.API1.models.Customer;

public class CustomerDto {
    private Long id;
    private String name;

    // Empty constructor (required for frameworks like Jackson)
    public CustomerDto() {
    }

    // Constructor to convert from Customer entity to DTO
    public CustomerDto(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
    }

    // Getter and Setter for ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
