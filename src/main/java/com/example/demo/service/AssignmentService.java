package com.example.demo.service;

import com.example.demo.entity.Assignment;
import com.example.demo.repository.AssignmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.service.dto.AssignmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssignmentService {
    private final AssignmentRepository assignmentRepository;
    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;

    //Create
    public Assignment createAssignment(Long employeeId, Long projectId, AssignmentDTO assignmentDTO) {
        Assignment assignment = new Assignment();
        assignment.setEmployee(employeeRepository.findById(employeeId).get());
        assignment.setProject(projectRepository.findById(projectId).get());
        assignment.setNumberOfHour(assignmentDTO.getNumberOfHour());
        return assignmentRepository.save(assignment);
    }

    //Read
    public List<Assignment> findAllAsignment() {
        return assignmentRepository.findAll();
    }

    public Assignment findByAssignmentId(Long id){
        return assignmentRepository.findById(id).get();
    }

    //Update
    public Assignment updateAssignmentById(Long id, AssignmentDTO assignmentDTO){
        Assignment assignment = assignmentRepository.findById(id).get();
        assignment.setNumberOfHour(assignmentDTO.getNumberOfHour());
        return assignmentRepository.save(assignment);
    }

    //Delete
    public void deleteAssignmentById(Long id){
        assignmentRepository.delete(assignmentRepository.findById(id).get());
    }
}
