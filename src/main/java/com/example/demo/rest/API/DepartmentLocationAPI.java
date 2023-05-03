package com.example.demo.rest.API;

import com.example.demo.entity.DepartmentLocation;
import com.example.demo.service.dto.DepartmentLocationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/departments/{deptId}/location")
public interface DepartmentLocationAPI {

    @PostMapping
    ResponseEntity<DepartmentLocation> createDepartmentLocation(@PathVariable("deptId") Long deptId,
                                                               @RequestBody DepartmentLocationDTO departmentLocationDTO);

   @GetMapping(value="/{locationId}")
    ResponseEntity<DepartmentLocation> findByIDLocation( @PathVariable("locationId") Long locationId);

    @PutMapping(value ="/{locationId}")
    ResponseEntity<DepartmentLocation> updateLocation(@PathVariable("locationId") Long id, @RequestBody DepartmentLocationDTO departmentLocationDTO);

    @DeleteMapping(value = "/{locationId}")
    ResponseEntity<Void> deleteLocationById(@PathVariable("locationId") Long id);
}
