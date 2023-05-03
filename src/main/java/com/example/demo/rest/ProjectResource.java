package com.example.demo.rest;

import com.example.demo.entity.Project;
import com.example.demo.rest.API.ProjectAPI;
import com.example.demo.service.ProjectService;
import com.example.demo.service.dto.ProjectDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProjectResource implements ProjectAPI {
    private final ProjectService projectService;

    @Override
    public ResponseEntity<Project> createProject(Long deptid, ProjectDTO projectDTO) {
        return ResponseEntity.ok(projectService.createProject(deptid, projectDTO));

    }

    @Override
    public ResponseEntity<Project> findProjectById(Long id) {
        return ResponseEntity.ok(projectService.findProjectByID(id));
    }

    @Override
    public ResponseEntity<Project> updateProjectById(Long id, ProjectDTO projectDTO) {
        return ResponseEntity.ok(projectService.updateProjectById(id, projectDTO));
    }

    @Override
    public ResponseEntity<Void> deleteProjectById(Long id) {
        projectService.deleteProjectById(id);
        return ResponseEntity.noContent().build();
    }
}
