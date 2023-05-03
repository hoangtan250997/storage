package com.example.demo.rest.API;

import com.example.demo.entity.Relatives;
import com.example.demo.service.dto.RelativesDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/departments/{deptId}/employees/{employeeId}/relatives")
public interface RelativesAPI {

    @PostMapping
    ResponseEntity<Relatives> createRelatives(@PathVariable("employeeId") Long employeeId,
                                                           @RequestBody RelativesDTO relativesDTO);

    @GetMapping(value = "/{id}")
        ResponseEntity<Relatives> findByRelativeId(@PathVariable("id") Long id);

    @PutMapping(value = "/{id}")
    ResponseEntity<Relatives> updateRelativeById(@PathVariable("id") Long id, @RequestBody RelativesDTO relativesDTO);

    @DeleteMapping(value =  "/{id}")
    ResponseEntity<Void> deleteRelativeById(@PathVariable("id") Long id);
}
