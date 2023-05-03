package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.dto.DepartmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public List<Department> getAllDepartmnet(){
        return departmentRepository.findAll();
    }

    public List<Department> getDepartmentByDate(LocalDate localDate){
        return departmentRepository.findByStartDate(localDate);
    }
    public Department createDepartment(DepartmentDTO departmentDTO){
        Department department = new Department();
        department.setName(departmentDTO.getName());
        return departmentRepository.save(department);
    }
    public void deleteDepartment(Long deptId) {
        departmentRepository.deleteById(deptId);
    }

    public Department updateDepartment(Long deptId, DepartmentDTO departmentDTO) {
        Optional<Department> department = departmentRepository.findById(deptId);
        Department updateDepartment = department.get();
        updateDepartment.setName(departmentDTO.getName());
        updateDepartment.setStartDate(departmentDTO.getStartDate());
        return departmentRepository.save(updateDepartment);
    }
}
