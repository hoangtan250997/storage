package com.example.demo.rest;

import com.example.demo.entity.Employee;
import com.example.demo.rest.API.EmployeeAPI;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmployeeResource implements EmployeeAPI {
    private final EmployeeService employeeService;

    @Override
    public ResponseEntity<Employee> createEmployeebyDepartment(Long deptId, EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(employeeService.createEmployee(employeeDTO, deptId));
    }

    @Override
    public ResponseEntity<Employee> findByIdEmployee(Long id) {
        return ResponseEntity.ok(employeeService.getByIdEmployees(id));
    }

    @Override
    public ResponseEntity<Employee> updateEmployeeById(Long id, EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(employeeService.updateEmployeeById(id, employeeDTO));
    }

    @Override
    public ResponseEntity<Void> deleteEmployeeById(Long id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.noContent().build();
    }


}
