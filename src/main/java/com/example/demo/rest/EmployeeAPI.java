package com.example.demo.rest;

import com.example.demo.entity.Employee;
import com.example.demo.service.dto.EmployeeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/departments/{deptId}/employees")
public interface EmployeeAPI {

    @PostMapping
    ResponseEntity<Employee> getEmployeebyDepartment(@PathVariable("deptId") Long deptId,
                                                     @RequestBody EmployeeDTO employeeDTO);

    @GetMapping()
    ResponseEntity<List<Employee>> getAllEmpployee();
}
