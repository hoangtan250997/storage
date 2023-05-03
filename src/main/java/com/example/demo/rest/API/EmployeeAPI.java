package com.example.demo.rest.API;

import com.example.demo.entity.Employee;
import com.example.demo.service.dto.EmployeeDTO;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/departments/{deptId}/employees")
public interface EmployeeAPI {

    @PostMapping
    ResponseEntity<Employee> createEmployeebyDepartment(@PathVariable("deptId") Long deptId,
                                                        @RequestBody EmployeeDTO employeeDTO);

    @GetMapping(value = "/{id}")
    ResponseEntity<Employee> findByIdEmployee(@PathVariable("id") Long id);

    @PutMapping(value = "/{id}")
    ResponseEntity<Employee> updateEmployeeById(@PathVariable("id") Long id, @RequestBody EmployeeDTO employeeDTO);

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> deleteEmployeeById(@PathVariable("id") Long id);

        @GetMapping(value = "/lastNameAndFirstName")
    ResponseEntity<List<Employee>> getEmployeeByLastNameAndFirstName(@Param("lastName") String lastName, @Param("firstName") String firstName);
}
