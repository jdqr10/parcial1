package com.example.API1.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.API1.dto.EmployeeDto;
import com.example.API1.repository.EmployeesRepository;
import com.example.API1.models.Employee;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeesRepository employeesRepository;

    // Get method to retrieves employees
    public List<EmployeeDto> findAll(){
        List<EmployeeDto> employeeToReturn = new ArrayList<>();
        List<Employee> employees = employeesRepository.findAll();

        // Convert each Employee entity to a EmployeeDto
        for(Employee employee : employees){
            EmployeeDto employeeDtoGet = new EmployeeDto(employee);
            employeeToReturn.add(employeeDtoGet);
        }

        return employeeToReturn;
    }


    //Post method to create employees
    public EmployeeDto saveEmployee(EmployeeDto request){
        Employee employee = new Employee();
        employee.setName(request.getName());

        // Save entity to the db
        Employee savEmployee = employeesRepository.save(employee);

        //Convert saved entity back to DTO and return it
        return new EmployeeDto(savEmployee);
    }

    //Delete method to delete Employees
    public String deleteEmployee(Long id){
        if (employeesRepository.existsById(id)) {
            employeesRepository.deleteById(id);
            return "Employee successfully deleted";
        }else{
            return "Employee not found";
        }
    }

    // Método para actualizar un empleado existente
public EmployeeDto updateEmployee(Long id, EmployeeDto request) {
    if (employeesRepository.existsById(id)) {
        Employee employee = employeesRepository.findById(id).get();
        employee.setName(request.getName()); // Actualiza el nombre

        // Guarda los cambios en la base de datos
        Employee updatedEmployee = employeesRepository.save(employee);
        return new EmployeeDto(updatedEmployee);
    } else {
        throw new RuntimeException("Employee not found with id: " + id);
    }
}

}
