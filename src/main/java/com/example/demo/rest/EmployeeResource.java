package com.example.demo.rest;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeResource implements EmployeeAPI{
    private final EmployeeService employeeService;

    @Override
    public ResponseEntity<Employee> getEmployeebyDepartment(Long deptId, EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(employeeService.createEmployee(employeeDTO, deptId));
    }

    @Override
    public ResponseEntity<List<Employee>> getAllEmpployee() {
        return  ResponseEntity.ok(employeeService.getAllEmployees());
    }
}
