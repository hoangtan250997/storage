package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;


    //Create
    public Employee createEmployee(EmployeeDTO employeeDTO, Long deptId) {
        Optional<Department> department = departmentRepository.findById(deptId);

        Employee employee = new Employee();
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setGender(employeeDTO.getGender());
        if (department.isPresent())
            employee.setDepartment(department.get());
        return employeeRepository.save(employee);
    }

    //    Read
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getByIdEmployees(Long id) {
        return employeeRepository.findById(id).get();
    }


    //Update
    public Employee updateEmployeeById(Long id, EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(id).get();
        if (employee.getFirstName() != null) employee.setFirstName(employeeDTO.getFirstName());
        if (employee.getLastName() != null) employee.setLastName(employeeDTO.getLastName());
        if (employee.getGender() != null) employee.setGender(employeeDTO.getGender());

        return employeeRepository.save(employee);
    }

    //Delete
    public void deleteEmployeeById(Long id){
        employeeRepository.deleteById(id);
    }
}






