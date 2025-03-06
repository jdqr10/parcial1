package com.example.API1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.API1.dto.EmployeeDto;
import com.example.API1.services.EmployeeService;

import lombok.Delegate;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Retrieves all employees
    @GetMapping("/getEmployees")
    public List<EmployeeDto> getAllCategories() {
        return employeeService.findAll();
    }

    // Save a new employee
    @PostMapping("/saveEmployee")
    public EmployeeDto saveEmployee(@RequestBody EmployeeDto request) {
        return employeeService.saveEmployee(request);
    }

    // Delete employee by its ID
    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id);
    }

    // Update an existing employee
    @PutMapping("/updateEmployee/{id}")
    public EmployeeDto updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto request) {
        return employeeService.updateEmployee(id, request);
    }
}
