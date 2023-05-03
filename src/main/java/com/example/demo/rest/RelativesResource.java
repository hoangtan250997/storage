package com.example.demo.rest;

import com.example.demo.entity.Relatives;
import com.example.demo.rest.API.RelativesAPI;
import com.example.demo.service.RelativesService;
import com.example.demo.service.dto.RelativesDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RelativesResource implements RelativesAPI {
private final RelativesService relativesService;
    @Override
    public ResponseEntity<Relatives> createRelatives(Long employeeId, RelativesDTO relativesDTO) {
         return ResponseEntity.ok(relativesService.createRelatives(employeeId, relativesDTO));
    }

    @Override
    public ResponseEntity<Relatives> findByRelativeId(Long id) {
        return ResponseEntity.ok(relativesService.findByRelativeId(id));
    }

    @Override
    public ResponseEntity<Relatives> updateRelativeById(Long id, RelativesDTO relativesDTO) {
        return ResponseEntity.ok(relativesService.updateByRelativeId(id, relativesDTO));
    }

    @Override
    public ResponseEntity<Void> deleteRelativeById(Long id) {
        relativesService.deleteByRelativeId(id);
        return ResponseEntity.noContent().build();
    }
}
