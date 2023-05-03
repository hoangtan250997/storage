package com.example.demo.rest;

import com.example.demo.entity.*;
import com.example.demo.rest.API.FindAllAPI;
import com.example.demo.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FindAllResource implements FindAllAPI {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    private final DepartmentLocationService departmentLocationService;
    private final RelativesService relativesService;

    private final ProjectService projectService;

    @Override
    public ResponseEntity<List<Employee>> getAllEmpployee() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @Override
    public ResponseEntity<List<Department>> getAllDepartment() {
        return ResponseEntity.ok(departmentService.getAllDepartmnet());
    }

    @Override
    public ResponseEntity<List<DepartmentLocation>> getAllLocation() {
        return ResponseEntity.ok(departmentLocationService.gellAllLocation());
    }

    @Override
    public ResponseEntity<List<Relatives>> getAllRelatives() {
        return ResponseEntity.ok(relativesService.findAllRelatives());
    }

    @Override
    public ResponseEntity<List<Project>> findAllProjects() {
        return ResponseEntity.ok(projectService.findAll());
    }

}
