package com.example.demo.rest.API;

import com.example.demo.entity.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "/api/departments/")

public interface FindAllAPI {
    @GetMapping(value="/employees")
    ResponseEntity<List<Employee>> getAllEmpployee();

    @GetMapping
    ResponseEntity<List<Department>> getAllDepartment();

    @GetMapping(value="/locations")
    ResponseEntity<List<DepartmentLocation>> getAllLocation();

    @GetMapping(value="/relatives")
    ResponseEntity<List<Relatives>> getAllRelatives();
    @GetMapping(value = "/projects")
    ResponseEntity<List<Project>> findAllProjects();
    @GetMapping(value = "/assignments")
    ResponseEntity<List<Assignment>> findAll();

}
