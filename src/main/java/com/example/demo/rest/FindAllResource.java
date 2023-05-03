package com.example.demo.rest;

import com.example.demo.entity.Employee;
import com.example.demo.rest.API.FindAllAPI;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FindAllResource implements FindAllAPI {

   private final EmployeeService employeeService;



    @Override
    public ResponseEntity<List<Employee>> getAllEmpployee() {
        return  ResponseEntity.ok(employeeService.getAllEmployees());
    }


}
