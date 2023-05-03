package com.example.demo.rest;

import com.example.demo.entity.DepartmentLocation;
import com.example.demo.rest.API.DepartmentLocationAPI;
import com.example.demo.service.DepartmentLocationService;
import com.example.demo.service.dto.DepartmentLocationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class DepartmentLocationResource implements DepartmentLocationAPI {
    private final DepartmentLocationService departmentLocationService;

    @Override
    public ResponseEntity<DepartmentLocation> createDepartmentLocation(Long deptId, DepartmentLocationDTO departmentLocationDTO) {
        DepartmentLocation departmentLocation = departmentLocationService.createDepartment(departmentLocationDTO, deptId);
        return ResponseEntity.created(URI.create("/api/departments/" + departmentLocation.getId())).body(departmentLocation);
    }

    @Override
    public ResponseEntity<DepartmentLocation> findByIDLocation(Long locationId) {
        return ResponseEntity.ok(departmentLocationService.getByIdDepartmentLocation(locationId));
    }

    @Override
    public ResponseEntity<DepartmentLocation> updateLocation(Long id, DepartmentLocationDTO departmentLocationDTO) {
        return ResponseEntity.ok(departmentLocationService.updateLocation(id, departmentLocationDTO));
    }

    @Override
    public ResponseEntity<Void> deleteLocationById(Long id) {
        departmentLocationService.deleteLocationById(id);
        return ResponseEntity.noContent().build();    }

}
