package com.example.demo.rest.API;

import com.example.demo.entity.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "/api/departments/")

public interface FindAllAPI {
    @GetMapping(value="/employees")
    ResponseEntity<List<Employee>> getAllEmpployee();


}
