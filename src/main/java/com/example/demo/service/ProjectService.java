package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Project;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.service.dto.ProjectDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final DepartmentRepository departmentRepository;
    private final ProjectRepository projectRepository;

    //Create
    public Project createProject(Long deptId, ProjectDTO projectDTO) {
        Optional<Department> department = departmentRepository.findById(deptId);
        Project project = new Project();

        project.setArea(projectDTO.getArea());
        project.setProjectName(projectDTO.getProjectName());

        if (department.isPresent()) project.setDepartment(department.get());

        return projectRepository.save(project);

    }

    //Read
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Project findProjectByID(Long id) {
        return projectRepository.findById(id).get();
    }

    //Update
    public Project updateProjectById(Long id, ProjectDTO projectDTO) {
        Project project = projectRepository.findById(id).get();


        if (projectDTO.getArea() != null) project.setArea(projectDTO.getArea());
        if (projectDTO.getProjectName() != null) project.setProjectName(projectDTO.getProjectName());

        return projectRepository.save(project);
    }

    //Delete
    public void deleteProjectById(Long id) {
        projectRepository.delete(projectRepository.findById(id).get());
    }

}
