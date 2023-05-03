package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "relatives")
public class Relatives {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(name = "gender", nullable = false)
    private Gender gender;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "relationship", nullable = false)
    private String relationship ;
    @ManyToOne
    @JoinColumn(name = "employeeid")
    private Employee employee;
}
