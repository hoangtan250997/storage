package com.example.demo.rest.API;

import com.example.demo.entity.Department;
import com.example.demo.service.dto.DepartmentDTO;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping(value = "/api/departments")
public interface DepartmentAPI {

    @GetMapping
    ResponseEntity<List<Department>> getAllDepartment();

    @GetMapping("/reports")
    ResponseEntity<List<Department>> getDepartmentByDate(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate);

    @PostMapping
    ResponseEntity<Department> createDepartment(@RequestBody DepartmentDTO departmentDTO);


    @DeleteMapping("/{deptId}")
    ResponseEntity<Void> deleteDepartment(@PathVariable("deptId") Long deptId);


    @PutMapping("/{deptId}")
    ResponseEntity<Department> updateDepartment(@PathVariable("deptId") Long deptId,
                                                @RequestBody DepartmentDTO departmentDTO);

    @GetMapping("/{deptId}")
    ResponseEntity<Department> getDepartmentById(@PathVariable("deptId") Long deptId);
}
