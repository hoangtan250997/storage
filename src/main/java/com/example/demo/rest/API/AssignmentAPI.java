package com.example.demo.rest.API;

import com.example.demo.entity.Assignment;
import com.example.demo.service.dto.AssignmentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/departments/{deptId}/employees/{employeeId}/projects/{projectId}/assignments")
public interface AssignmentAPI {
    @PostMapping
    ResponseEntity<Assignment> createAssignment(@PathVariable("employeeId") Long employeeId, @PathVariable("projectId") Long projectId, @RequestBody AssignmentDTO assignmentDTO);

    @GetMapping(value = "/{id}")
    ResponseEntity<Assignment> findbyAssignmentID(@PathVariable("id") Long id);

    @PutMapping(value = "/{id}")
    ResponseEntity<Assignment> updateAssignmentById(@PathVariable("id") Long id,@RequestBody AssignmentDTO assignmentDTO);

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> deleteAssignmentById(@PathVariable("id") Long id);
}
