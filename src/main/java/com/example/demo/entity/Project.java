package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long projectid;

    @Column(name = "area", nullable = false)
    private String area;

    @Column(name = "project_name", nullable = false)
    private String projectName;

    @ManyToOne
    @JoinColumn(name = "managed_department")
    private Department department;
}
