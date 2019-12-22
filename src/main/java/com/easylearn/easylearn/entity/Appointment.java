package com.easylearn.easylearn.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increament
    private Long id;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private int roomNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "appointment_student",
            joinColumns = {@JoinColumn(name = "appointment_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")}
    )
    private Set<Student> students;


    public void addStudent(Student student) {
        students.add(student);
    }
}
