package com.example.demo.service;


import com.example.demo.entity.Department;
import com.example.demo.entity.DepartmentLocation;
import com.example.demo.repository.DepartmentLocationRepository;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.dto.DepartmentLocationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentLocationService {
    private final DepartmentLocationRepository departmentLocationRepository;
    private final DepartmentRepository departmentRepository;
    //Create
    public DepartmentLocation createDepartment(DepartmentLocationDTO departmentLocationDTO, Long deptId){
        Optional<Department> department = departmentRepository.findById(deptId);
        DepartmentLocation departmentLocation = new DepartmentLocation();
        departmentLocation.setLocation(departmentLocationDTO.getLocation());
        if(department.isPresent())
            departmentLocation.setDepartment(department.get());
        return departmentLocationRepository.save(departmentLocation);
    }

    //Read
    public List<DepartmentLocation> gellAllLocation() {return departmentLocationRepository.findAll();}
    public DepartmentLocation getByIdDepartmentLocation(Long id) {

        return departmentLocationRepository.findById(id).get();
    }

    //Update
    public DepartmentLocation updateLocation(Long id, DepartmentLocationDTO departmentLocationDTO) {
        Optional<DepartmentLocation> departmentLocation = departmentLocationRepository.findById(id);
        DepartmentLocation updateLocation = departmentLocation.get();
        updateLocation.setLocation(departmentLocationDTO.getLocation());
        return departmentLocationRepository.save(updateLocation);
    }

    //Delete
    public void deleteLocationById (Long id){
        departmentLocationRepository.deleteById(id);
    }


}
