package com.example.demo.service.dto;

import com.example.demo.entity.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private Gender gender;
}
