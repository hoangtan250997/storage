package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Department_Location")
public class DepartmentLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "location", nullable = false)
    private String location;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;
}
