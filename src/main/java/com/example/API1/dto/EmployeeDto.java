package com.example.API1.dto;

import com.example.API1.models.Employee;

public class EmployeeDto {
    private Long id;
    private String name;

    // Empty constructor 
    public EmployeeDto() {
    }

    public EmployeeDto(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
