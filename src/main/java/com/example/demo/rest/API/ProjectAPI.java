package com.example.demo.rest.API;

import com.example.demo.entity.Project;
import com.example.demo.service.dto.ProjectDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/departments/{deptId}/projects")

public interface ProjectAPI {
    @PostMapping
    ResponseEntity<Project> createProject(@PathVariable("deptId") Long deptid, @RequestBody ProjectDTO projectDTO);

    @GetMapping(value = "/{id}")
    ResponseEntity<Project> findProjectById(@PathVariable("id")Long id);

    @PutMapping(value = "/{id}")
    ResponseEntity<Project> updateProjectById(@PathVariable("id") Long id, @RequestBody ProjectDTO projectDTO);
    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> deleteProjectById(@PathVariable("id") Long id);
}
