package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Relatives;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.RelativesRepository;
import com.example.demo.service.dto.RelativesDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RelativesService {
    private final RelativesRepository relativesRepository;
    private final EmployeeRepository employeeRepository;


    //Create
    public Relatives createRelatives(Long id, RelativesDTO relativesDTO) {
        Optional<Employee> employee = employeeRepository.findById(id);

        Relatives relatives = new Relatives();
        relatives.setFullName(relativesDTO.getFullName());
        relatives.setGender(relativesDTO.getGender());
        relatives.setPhoneNumber(relativesDTO.getPhoneNumber());
        relatives.setRelationship(relativesDTO.getRelationship());
        if (employee.isPresent()) relatives.setEmployee(employee.get());

        return relativesRepository.save(relatives);
    }

    //Read
    public List<Relatives> findAllRelatives() {
        return relativesRepository.findAll();
    }

    public Relatives findByRelativeId(Long id) {
        return relativesRepository.findById(id).get();
    }

    //Update
    public Relatives updateByRelativeId(Long id, RelativesDTO relativesDTO) {
        Relatives relatives = relativesRepository.findById(id).get();
        relatives.setFullName(relativesDTO.getFullName());
        relatives.setGender(relativesDTO.getGender());
        relatives.setPhoneNumber(relativesDTO.getPhoneNumber());
        relatives.setRelationship(relativesDTO.getRelationship());
        return relativesRepository.save(relatives);
    }

    //Delete
    public void deleteByRelativeId(Long id){
         relativesRepository.delete(relativesRepository.findById(id).get());
    }
}
