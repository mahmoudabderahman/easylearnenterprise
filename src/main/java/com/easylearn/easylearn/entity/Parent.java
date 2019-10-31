package com.easylearn.easylearn.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increament
    private Long id;

    @Column(nullable = false)
    private String fatherFirstName;

    @Column(nullable = false)
    private String fatherLastName;

    @Column(nullable = false)
    private String motherFirstName;

    @Column(nullable = false)
    private String motherLastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "parent")
    private Set<Student> students;
}
