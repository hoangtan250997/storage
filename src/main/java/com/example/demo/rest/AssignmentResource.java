package com.example.demo.rest;

import com.example.demo.entity.Assignment;
import com.example.demo.rest.API.AssignmentAPI;
import com.example.demo.service.AssignmentService;
import com.example.demo.service.dto.AssignmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AssignmentResource implements AssignmentAPI {
private final AssignmentService assignmentService;
    @Override
    public ResponseEntity<Assignment> createAssignment(Long employeeId, Long projectId, AssignmentDTO assignmentDTO) {
        return ResponseEntity.ok(assignmentService.createAssignment(employeeId, projectId, assignmentDTO));
    }

    @Override
    public ResponseEntity<Assignment> findbyAssignmentID(Long id) {
        return ResponseEntity.ok(assignmentService.findByAssignmentId(id));
    }

    @Override
    public ResponseEntity<Assignment> updateAssignmentById(Long id, AssignmentDTO assignmentDTO) {
        return ResponseEntity.ok(assignmentService.updateAssignmentById(id, assignmentDTO));
    }

    @Override
    public ResponseEntity<Void> deleteAssignmentById(Long id) {
        return ResponseEntity.noContent().build();
    }


}
