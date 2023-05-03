package com.example.demo.rest;

import com.example.demo.entity.Department;
import com.example.demo.rest.API.DepartmentAPI;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.dto.DepartmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentResource implements DepartmentAPI {

    private final DepartmentService departmentService;
    @Override
    public ResponseEntity<List<Department>> getAllDepartment() {
        return ResponseEntity.ok(departmentService.getAllDepartmnet());
    }

    @Override
    public ResponseEntity<List<Department>> getDepartmentByDate(LocalDate startDate) {
        return ResponseEntity.ok(departmentService.getDepartmentByDate(startDate));
    }

    @Override
    public ResponseEntity<Department> createDepartment(DepartmentDTO departmentDTO) {
        Department department = departmentService.createDepartment(departmentDTO);
        return ResponseEntity.created(URI.create("/api/departments/" + department.getId())).body(department);
    }

    @Override
    public ResponseEntity<Void> deleteDepartment(Long deptId) {
        departmentService.deleteDepartment(deptId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Department> updateDepartment(Long deptId, DepartmentDTO departmentDTO) {
        Department result =  departmentService.updateDepartment(deptId, departmentDTO);
        return ResponseEntity.ok().body(result);
    }

    @Override
    public ResponseEntity<Department> getDepartmentById(Long deptId) {
          return ResponseEntity.ok(departmentService.getByIdDepartment(deptId));
    }

}
